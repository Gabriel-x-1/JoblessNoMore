const container = document.querySelector(".container");

function enableSwipe(card) {
  let startX = 0;

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

const topCard = document.getElementById("swipe-card");
enableSwipe(topCard);
