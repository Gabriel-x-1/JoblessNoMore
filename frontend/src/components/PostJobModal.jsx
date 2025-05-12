import { useState } from "react";

export default function PostJobModal({ onClose }) {
  const [job, setJob] = useState({
    title: "",
    location: "",
    type: "Full-Time",
    salary: "",
    level: "",
    techStack: "",
    description: "",
  });

  const handleChange = (e) => {
    setJob({ ...job, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("New job posted:", job);
    onClose();
  };

  return (
    <div className="fixed inset-0 bg-black/40 backdrop-blur-sm flex items-center justify-center z-50">
      <div className="bg-white rounded-lg w-full max-w-2xl p-6 max-h-[90vh] overflow-y-auto">
        <h2 className="text-xl font-semibold mb-4">Post a New Job</h2>

        <form onSubmit={handleSubmit} className="space-y-4 text-sm">
          <input name="title" value={job.title} onChange={handleChange} required
            className="w-full border rounded px-3 py-2" placeholder="Job Title" />
          
          <input name="location" value={job.location} onChange={handleChange} required
            className="w-full border rounded px-3 py-2" placeholder="Location (e.g., Berlin, Remote)" />

          <input name="salary" value={job.salary} onChange={handleChange}
            className="w-full border rounded px-3 py-2" placeholder="Salary (e.g., €70,000 – €90,000)" />

          <select name="type" value={job.type} onChange={handleChange}
            className="w-full border rounded px-3 py-2">
            <option value="Full-Time">Full-Time</option>
            <option value="Part-Time">Part-Time</option>
            <option value="Contract">Contract</option>
          </select>

          <select name="level" value={job.level} onChange={handleChange}
            className="w-full border rounded px-3 py-2">
            <option value="Junior">Junior</option>
            <option value="Mid">Mid</option>
            <option value="Senior">Senior</option>
            <option value="Lead">Lead</option>
          </select>

          <input name="techStack" value={job.techStack} onChange={handleChange}
            className="w-full border rounded px-3 py-2" placeholder="Tech Stack (comma-separated)" />

          <textarea name="description" value={job.description} onChange={handleChange} rows="8"
            className="w-full border rounded px-3 py-2" placeholder="Job Description with markdown..." />

          <div className="flex justify-end gap-2 pt-4">
            <button type="button" onClick={onClose}
              className="bg-gray-200 hover:bg-gray-300 text-gray-700 px-4 py-2 rounded">
              Cancel
            </button>
            <button type="submit"
              className="bg-blue-600 hover:bg-blue-700 text-white px-4 py-2 rounded">
              Post Job
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
