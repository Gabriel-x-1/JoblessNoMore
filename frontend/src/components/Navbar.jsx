import { useAuth } from "../context/AuthContext";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";

export default function Navbar() {
  const { user, logout } = useAuth();
  const [menuOpen, setMenuOpen] = useState(false);

  useEffect(() => {
    const handleResize = () => {
      if (window.innerWidth >= 768 && menuOpen) {
        setMenuOpen(false);
      }
    };
    window.addEventListener("resize", handleResize);
    return () => window.removeEventListener("resize", handleResize);
  }, [menuOpen]);

  return (
    <>
      <nav className="fixed top-0 left-0 w-full bg-white text-gray-800 shadow-md z-50">
        <div className="max-w-6xl mx-auto px-4 py-3 flex items-center justify-between">
          <Link to="/" className="text-xl font-bold text-blue-600">
            JobLessNoMore
          </Link>

          <div className="hidden md:flex items-center gap-6">
            {!user ? (
              <>
                <Link to="/login" className="hover:text-blue-600">
                  Login
                </Link>
                <Link to="/register" className="hover:text-blue-600">
                  Register
                </Link>
              </>
            ) : (
              <>
                <Link to="/dashboard" className="hover:text-blue-600">
                  Dashboard
                </Link>
                <Link to="/profile" className="hover:text-blue-600">
                  Profile
                </Link>

                <Link to="/swipe" className="hover:text-blue-600">
                  Swipe
                </Link>

                <button
                  onClick={logout}
                  className="text-red-500 hover:underline"
                >
                  Logout
                </button>
              </>
            )}
          </div>

          <div className="md:hidden">
            <button
              onClick={() => setMenuOpen(!menuOpen)}
              className="relative w-6 h-6 flex flex-col justify-center items-center"
              aria-label="Toggle menu"
            >
              <span
                className={`absolute w-5 h-[2px] bg-black transition duration-300 ${
                  menuOpen ? "rotate-45" : "-translate-y-[6px]"
                }`}
              />
              <span
                className={`absolute w-5 h-[2px] bg-black transition duration-300 ${
                  menuOpen ? "opacity-0" : "opacity-100"
                }`}
              />
              <span
                className={`absolute w-5 h-[2px] bg-black transition duration-300 ${
                  menuOpen ? "-rotate-45" : "translate-y-[6px]"
                }`}
              />
            </button>
          </div>
        </div>
      </nav>

      <div
        onClick={() => setMenuOpen(false)}
        className={`fixed inset-0 bg-black/40 z-40 transition-opacity duration-300 ${
          menuOpen
            ? "opacity-100 pointer-events-auto"
            : "opacity-0 pointer-events-none"
        }`}
      />

      <div
        className={`fixed top-14 left-0 w-full bg-white text-gray-800 z-50 shadow-lg transition-all duration-300 ease-in-out transform ${
          menuOpen
            ? "translate-y-0 opacity-100 pointer-events-auto"
            : "-translate-y-5 opacity-0 pointer-events-none"
        }`}
      >
        <div className="flex flex-col items-center text-base py-6 space-y-2">
          {!user ? (
            <>
              <Link
                to="/login"
                onClick={() => setMenuOpen(false)}
                className="w-full text-center py-2 hover:text-blue-600"
              >
                Login
              </Link>
              <Link
                to="/register"
                onClick={() => setMenuOpen(false)}
                className="w-full text-center py-2 hover:text-blue-600"
              >
                Register
              </Link>
            </>
          ) : (
            <>
              <Link
                to="/dashboard"
                onClick={() => setMenuOpen(false)}
                className="w-full text-center py-2 hover:text-blue-600"
              >
                Dashboard
              </Link>
              <Link
                to="/profile"
                onClick={() => setMenuOpen(false)}
                className="w-full text-center py-2 hover:text-blue-600"
              >
                Profile
              </Link>

              <Link
                to="/swipe"
                onClick={() => setMenuOpen(false)}
                className="w-full text-center py-2 hover:text-blue-600"
              >
                Swipe
              </Link>

              <button
                onClick={() => {
                  setMenuOpen(false);
                  logout();
                }}
                className="w-full text-center py-2 text-red-500 hover:underline"
              >
                Logout
              </button>
            </>
          )}
        </div>
      </div>
    </>
  );
}
