document.addEventListener("DOMContentLoaded", () => {
  const form = document.querySelector(".auth-form");
  const nameInput = form.querySelector('input[name="name"]');
  const emailInput = form.querySelector('input[name="email"]');
  const passwordInput = form.querySelector('input[name="password"]');
  const confirmInput = form.querySelector('input[name="confirm_password"]');

  form.addEventListener("submit", (e) => {
    let errors = [];

    if (nameInput) {
      nameInput.value = nameInput.value
        .toLowerCase()
        .split(" ")
        .filter((word) => word.trim() !== "")
        .map((word) => word[0].toUpperCase() + word.slice(1))
        .join(" ");
    }

    const emailRegex = /^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$/;
    if (!emailRegex.test(emailInput.value.trim())) {
      errors.push("Please enter a valid email address.");
    }

    if (confirmInput && passwordInput.value !== confirmInput.value) {
      errors.push("Passwords do not match.");
    }

    if (errors.length > 0) {
      e.preventDefault();
      const errorBox = document.getElementById("form-error");
      if (errors.length > 0) {
        e.preventDefault();
        errorBox.textContent = errors.join(" ");
        errorBox.style.display = "block";
      } else {
        errorBox.style.display = "none";
      }
    }
  });
});
