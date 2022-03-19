//animação nav e ícone hamburger
let navMobile = document.querySelector(".nav-links");
let hamburger = document.querySelector(".mobile-nav-icon")

hamburger.addEventListener("click", function() {
    hamburger.classList.toggle("open");
    navMobile.classList.toggle("closed");
})
