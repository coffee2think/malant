//banner_scroll.js
const bannerControls = document.querySelector(".banner-controls");
const prevButton = document.querySelector(".prev");
const nextButton = document.querySelector(".next");
const indicatorContainer = document.querySelector(".indicator-container");
const bannerImage = document.querySelector(".banner-image");

const images = [
  "/MalantStore/resources/images/메인배너.jpg",
  "/MalantStore/resources/images/1.jpg",
  "/MalantStore/resources/images/상품이미지.jpg",
  "/MalantStore/resources/images/2.jpg",
  // 추가 이미지
];

let currentImageIndex = 0;
let isAutoScrolling = true; // 자동 스크롤 여부

function updateBanner() {
  bannerImage.src = images[currentImageIndex];
  updateIndicators();
}

function updateIndicators() {
  indicatorContainer.innerHTML = "";
  for (let i = 0; i < images.length; i++) {
    const indicator = document.createElement("div");
    indicator.classList.add("indicator");
    if (i === currentImageIndex) {
      indicator.classList.add("active");
    }
    indicatorContainer.appendChild(indicator);
  }
}

function scrollToNextImage() {
  currentImageIndex = (currentImageIndex + 1) % images.length;
  updateBanner();
}

function scrollToPrevImage() {
  currentImageIndex = (currentImageIndex - 1 + images.length) % images.length;
  updateBanner();
}

function startAutoScroll() {
  setInterval(() => {
    if (isAutoScrolling) {
      scrollToNextImage();
    }
  }, 3000);
}

prevButton.addEventListener("click", () => {
  scrollToPrevImage();
  isAutoScrolling = false; // 화살표를 클릭하면 자동 스크롤 중단
});

nextButton.addEventListener("click", () => {
  scrollToNextImage();
  isAutoScrolling = false; // 화살표를 클릭하면 자동 스크롤 중단
});

bannerControls.addEventListener("click", () => {
  isAutoScrolling = !isAutoScrolling; // 화살표 영역 클릭 시 자동 스크롤링 토글
});

updateBanner();
startAutoScroll();
