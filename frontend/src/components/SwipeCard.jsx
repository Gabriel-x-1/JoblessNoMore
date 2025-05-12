import { useState, useRef } from "react";

export default function SwipeCard({
  job,
  onSwipeComplete,
  isTop,
  onSwipeMove,
}) {
  const cardRef = useRef(null);
  const startX = useRef(0);
  const deltaX = useRef(0);
  const [swipingOut, setSwipingOut] = useState(false);
  const [direction, setDirection] = useState(null);

const handleDragStart = (clientX) => {
  startX.current = clientX;

  if (cardRef.current) {
    cardRef.current.style.transition = "none";
  }
};

const handleDragMove = (clientX) => {
  deltaX.current = clientX - startX.current;

  if (cardRef.current && !swipingOut) {
    cardRef.current.style.transform = `translateX(${deltaX.current}px) rotate(${deltaX.current * 0.05}deg)`;
  }

  if (onSwipeMove) {
    onSwipeMove(deltaX.current);
  }
};


const handleDragEnd = () => {
  const distance = deltaX.current;
  const dir = distance > 0 ? "right" : "left";

  if (Math.abs(distance) > 100) {
    setDirection(dir);
    setSwipingOut(true);

    if (cardRef.current) {
      cardRef.current.style.transition = "transform 0.4s ease-out";
      cardRef.current.style.transform = `translateX(${dir === "right" ? 1500 : -1500}px) rotate(${dir === "right" ? 45 : -45}deg)`;
    }

    setTimeout(() => {
      onSwipeComplete();
    }, 400);
  } else {
    if (cardRef.current) {
      cardRef.current.style.transition = "transform 0.3s ease";
      cardRef.current.style.transform = "translateX(0px) rotate(0deg)";
    }
  }

  if (onSwipeMove) {
    onSwipeMove(0);
  }
};


  const handleMouseDown = (e) => {
    handleDragStart(e.clientX);
    const onMouseMove = (e) => handleDragMove(e.clientX);
    const onMouseUp = () => {
      handleDragEnd();
      document.removeEventListener("mousemove", onMouseMove);
      document.removeEventListener("mouseup", onMouseUp);
    };
    document.addEventListener("mousemove", onMouseMove);
    document.addEventListener("mouseup", onMouseUp);
  };

  const handleTouchStart = (e) => handleDragStart(e.touches[0].clientX);
  const handleTouchMove = (e) => handleDragMove(e.touches[0].clientX);
  const handleTouchEnd = () => handleDragEnd();

  return (
    <div
      ref={cardRef}
      className={`select-none absolute w-full h-full bg-white rounded-xl shadow-lg p-6 flex flex-col justify-between transition-transform duration-500 ${
        swipingOut
          ? direction === "right"
            ? "swipe-out-right"
            : "swipe-out-left"
          : ""
      } ${isTop ? "z-10" : "z-0 scale-95 translate-y-2"}`}
      onMouseDown={isTop ? handleMouseDown : null}
      onTouchStart={isTop ? handleTouchStart : null}
      onTouchMove={isTop ? handleTouchMove : null}
      onTouchEnd={isTop ? handleTouchEnd : null}
      style={{ touchAction: "none", cursor: isTop ? "grab" : "default" }}
    >
      <div>
        <h2 className="text-2xl font-semibold text-gray-800">{job.title}</h2>
        <p className="text-gray-600 mb-2">{job.company}</p>
        <div className="flex justify-between text-sm text-gray-500 mb-4">
          <span>📍 {job.location}</span>
          <span>💼 {job.type}</span>
        </div>
      </div>
      <div className="flex-1 bg-gray-50 p-3 rounded text-sm text-gray-700 whitespace-pre-line overflow-auto">
        {job.description}
      </div>
    </div>
  );
}
