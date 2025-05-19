const container = document.querySelector(".container");
const token = document.querySelector("meta[name='_csrf']").content;
const header = document.querySelector("meta[name='_csrf_header']").content;

async function handleSwipe(jobId, action) {
  try {
    const response = await fetch(`/api/jobs/${jobId}/interact?action=${action}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        [header]: token
      },
      credentials: 'include'
    });

    if (!response.ok) {
      console.error("Failed to record interaction");
      return;
    }

    // Find and remove the card
    const card = document.querySelector(`[data-job-id="${jobId}"]`);
    if (card) {
      card.style.transition = "all 0.3s ease";
      card.style.transform = `translateX(${action === 'APPLIED' ? 1000 : -1000}px) rotate(${action === 'APPLIED' ? 20 : -20}deg)`;

      setTimeout(() => {
        card.remove();
        const stack = document.querySelector(".card-stack");
        const nextCard = stack.querySelector(".card:nth-child(1)");

        if (nextCard) {
          nextCard.setAttribute("id", "swipe-card");
          nextCard.style.zIndex = "2";
          enableSwipe(nextCard);
        } else {
          stack.style.display = "none";
          document.querySelector(".no-more-cards").style.display = "flex";
        }
      }, 300);
    }
  } catch (error) {
    console.error("Error:", error);
  }
}

function enableSwipe(card) {
  if (!card) return;

  let startX = 0;
  const jobId = card.getAttribute("data-job-id");

  const onMouseDown = (e) => {
    startX = e.clientX;

    const onMouseMove = (e) => {
      const deltaX = e.clientX - startX;
      card.style.transform = `translateX(${deltaX}px) rotate(${
        deltaX * 0.05
      }deg)`;

      if (deltaX < -30) {
        container.classList.add("swipe-left");
        container.classList.remove("swipe-right");
      } else if (deltaX > 30) {
        container.classList.add("swipe-right");
        container.classList.remove("swipe-left");
      } else {
        container.classList.remove("swipe-left");
        container.classList.remove("swipe-right");
      }
    };

    const onMouseUp = (e) => {
      const deltaX = e.clientX - startX;

      if (Math.abs(deltaX) > 100) {
        const action = deltaX > 0 ? "APPLIED" : "REJECTED";
        handleSwipe(jobId, action);

        card.style.transition = "all 0.3s ease";
        card.style.transform = `translateX(${
          deltaX > 0 ? 1000 : -1000
        }px) rotate(${deltaX * 0.1}deg)`;

        setTimeout(() => {
          card.remove();
          container.classList.remove("swipe-left", "swipe-right");

          const stack = document.querySelector(".card-stack");
          const nextCard = stack.querySelector(".card:nth-child(1)");

          if (nextCard) {
            nextCard.setAttribute("id", "swipe-card");
            nextCard.style.zIndex = "2";
            enableSwipe(nextCard);
          } else {
            stack.style.display = "none";
            document.querySelector(".no-more-cards").style.display = "flex";
          }
        }, 300);
      } else {
        card.style.transform = "translateX(0) rotate(0deg)";
        container.classList.remove("swipe-left", "swipe-right");
      }

      document.removeEventListener("mousemove", onMouseMove);
      document.removeEventListener("mouseup", onMouseUp);
    };

    document.addEventListener("mousemove", onMouseMove);
    document.addEventListener("mouseup", onMouseUp);
  };

  card.addEventListener("mousedown", onMouseDown);
}

// Initialize swipe functionality only when DOM is fully loaded
document.addEventListener("DOMContentLoaded", () => {
  const topCard = document.getElementById("swipe-card");
  if (topCard) {
    enableSwipe(topCard);
  }

  // Add click handlers for buttons
  document.addEventListener('click', (e) => {
    if (e.target.closest('.action-btn')) {
      const button = e.target.closest('.action-btn');
      const jobId = button.getAttribute('data-job-id');
      const action = button.classList.contains('apply') ? 'APPLIED' : 'REJECTED';
      handleSwipe(jobId, action);
    }
  });
});
