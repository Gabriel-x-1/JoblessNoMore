import { Link } from "react-router-dom";

export default function Home() {
  return (
    <main className="min-h-screen bg-gray-100 flex flex-col items-center justify-center text-center px-4 pt-20">
      <section className="max-w-3xl">
        <h1 className="text-4xl sm:text-5xl font-extrabold text-gray-800 mb-4 leading-tight">
          Find Your Dream Job or Hire Top Talent
        </h1>
        <p className="text-lg text-gray-600 mb-8">
          Whether you're a developer looking for your next big opportunity or a company searching for great people — we've got you covered.
        </p>
        <div className="flex flex-col sm:flex-row justify-center gap-4">
          <Link
            to="/register"
            className="bg-blue-600 hover:bg-blue-700 text-white font-medium px-6 py-3 rounded shadow transition"
          >
            Get Started
          </Link>
          <Link
            to="/login"
            className="border border-blue-600 text-blue-600 hover:bg-blue-50 font-medium px-6 py-3 rounded transition"
          >
            Log In
          </Link>
        </div>
      </section>

      <section className="mt-20 grid sm:grid-cols-2 lg:grid-cols-3 gap-8 max-w-5xl">
        <div className="bg-white p-6 rounded-lg shadow text-left">
          <h3 className="text-xl font-semibold mb-2 text-blue-600">Smart Matching</h3>
          <p className="text-sm text-gray-600">
            Our intelligent system matches candidates with jobs based on skills, preferences, and goals.
          </p>
        </div>

        <div className="bg-white p-6 rounded-lg shadow text-left">
          <h3 className="text-xl font-semibold mb-2 text-blue-600">Swipe to Apply</h3>
          <p className="text-sm text-gray-600">
            A modern interface for employees to swipe through job offers — fast, simple, intuitive.
          </p>
        </div>

        <div className="bg-white p-6 rounded-lg shadow text-left">
          <h3 className="text-xl font-semibold mb-2 text-blue-600">Dashboard Insights</h3>
          <p className="text-sm text-gray-600">
            Employers can easily manage applicants while job seekers track their application status.
          </p>
        </div>
      </section>

    </main>
  );
}
