import React from "react";

const user = {
  role: "company",
  name: "Acme Inc.",
  applicants: [
    {
      name: "Jane Doe",
      title: "Frontend Developer",
      location: "Berlin",
      status: "Pending",
      skills: "React, CSS, TypeScript",
      education: "BSc Computer Science",
      contact: "jane@example.com",
    },
    {
      name: "John Smith",
      title: "Backend Developer",
      location: "Munich",
      status: "Shortlisted",
      skills: "Node.js, SQL, Docker",
      education: "MSc Software Engineering",
      contact: "john@example.com",
    },
    {
      name: "Jane Doe",
      title: "Frontend Developer",
      location: "Berlin",
      status: "Pending",
      skills: "React, CSS, TypeScript",
      education: "BSc Computer Science",
      contact: "jane@example.com",
    },
    {
      name: "John Smith",
      title: "Backend Developer",
      location: "Munich",
      status: "Shortlisted",
      skills: "Node.js, SQL, Docker",
      education: "MSc Software Engineering",
      contact: "john@example.com",
    },
    {
      name: "Jane Doe",
      title: "Frontend Developer",
      location: "Berlin",
      status: "Pending",
      skills: "React, CSS, TypeScript",
      education: "BSc Computer Science",
      contact: "jane@example.com",
    },
    {
      name: "John Smith",
      title: "Backend Developer",
      location: "Munich",
      status: "Shortlisted",
      skills: "Node.js, SQL, Docker",
      education: "MSc Software Engineering",
      contact: "john@example.com",
    },
    {
      name: "Jane Doe",
      title: "Frontend Developer",
      location: "Berlin",
      status: "Pending",
      skills: "React, CSS, TypeScript",
      education: "BSc Computer Science",
      contact: "jane@example.com",
    },
    {
      name: "John Smith",
      title: "Backend Developer",
      location: "Munich",
      status: "Shortlisted",
      skills: "Node.js, SQL, Docker",
      education: "MSc Software Engineering",
      contact: "john@example.com",
    },
  ],
};

// const user = {
//   role: "employee",
//   name: "John Doe",
//   appliedJobs: [
//     {
//       title: "Frontend Developer",
//       company: "InnovateX",
//       location: "Berlin, Germany",
//       status: "Under Review",
//       skills: "React, TypeScript, CSS",
//       type: "Full-Time",
//       salary: "€55,000",
//       date: "April 28, 2025",
//     },
//     {
//       title: "Backend Developer",
//       company: "DataSoft",
//       location: "Remote",
//       status: "Interview Scheduled",
//       skills: "Node.js, PostgreSQL, Docker",
//       type: "Contract",
//       salary: "€65,000",
//       date: "April 24, 2025",
//     },
//         {
//       title: "Frontend Developer",
//       company: "InnovateX",
//       location: "Berlin, Germany",
//       status: "Under Review",
//       skills: "React, TypeScript, CSS",
//       type: "Full-Time",
//       salary: "€55,000",
//       date: "April 28, 2025",
//     },
//     {
//       title: "Backend Developer",
//       company: "DataSoft",
//       location: "Remote",
//       status: "Interview Scheduled",
//       skills: "Node.js, PostgreSQL, Docker",
//       type: "Contract",
//       salary: "€65,000",
//       date: "April 24, 2025",
//     },
//         {
//       title: "Frontend Developer",
//       company: "InnovateX",
//       location: "Berlin, Germany",
//       status: "Under Review",
//       skills: "React, TypeScript, CSS",
//       type: "Full-Time",
//       salary: "€55,000",
//       date: "April 28, 2025",
//     },
//     {
//       title: "Backend Developer",
//       company: "DataSoft",
//       location: "Remote",
//       status: "Interview Scheduled",
//       skills: "Node.js, PostgreSQL, Docker",
//       type: "Contract",
//       salary: "€65,000",
//       date: "April 24, 2025",
//     },
//   ],
// };

export default function Dashboard() {
return (
  <main className="max-w-5xl mx-auto px-4 py-8 pt-24 text-gray-800">
    <section>
      <h2 className="text-3xl font-bold mb-8 text-gray-900 border-b pb-2">
        {user.role === "company" ? "Job Applicants" : "Your Applications"}
      </h2>

      <div className="max-h-[calc(100vh-220px)] overflow-y-auto space-y-5 pr-2">
        {user.role === "company" &&
          user.applicants.map((applicant, idx) => (
            <div
              key={idx}
              className="rounded-xl border border-gray-200 bg-white p-5 shadow-md hover:shadow-lg transition-all duration-200"
            >
              <div className="flex flex-col sm:flex-row sm:justify-between mb-2">
                <div>
                  <h3 className="text-lg font-semibold text-gray-900">
                    {applicant.name}
                  </h3>
                  <p className="text-sm text-gray-500">
                    {applicant.title} — {applicant.location}
                  </p>
                </div>
                <span
                  className={`mt-2 sm:mt-0 inline-block text-xs px-2 py-1 rounded-full font-medium self-start ${
                    applicant.status === "Shortlisted"
                      ? "bg-blue-100 text-blue-700"
                      : "bg-yellow-100 text-yellow-700"
                  }`}
                >
                  {applicant.status}
                </span>
              </div>

              <div className="grid sm:grid-cols-3 gap-3 text-sm text-gray-700 mb-3">
                <div>
                  <span className="font-medium text-gray-600">Skills:</span>{" "}
                  {applicant.skills}
                </div>
                <div>
                  <span className="font-medium text-gray-600">Education:</span>{" "}
                  {applicant.education}
                </div>
                <div>
                  <span className="font-medium text-gray-600">Contact:</span>{" "}
                  {applicant.contact}
                </div>
              </div>

              <div className="flex gap-3">
                <button className="bg-green-600 hover:bg-green-700 text-white text-sm font-medium px-4 py-1.5 rounded-md shadow">
                  Approve
                </button>
                <button className="bg-red-500 hover:bg-red-600 text-white text-sm font-medium px-4 py-1.5 rounded-md shadow">
                  Reject
                </button>
              </div>
            </div>
          ))}

        {user.role === "employee" &&
          user.appliedJobs.map((job, idx) => (
            <div
              key={idx}
              className="rounded-xl border border-gray-200 bg-white p-5 shadow-md hover:shadow-lg transition-all duration-200"
            >
              <div className="flex flex-col sm:flex-row sm:justify-between mb-2">
                <div>
                  <h3 className="text-lg font-semibold text-gray-900">
                    {job.title}
                  </h3>
                  <p className="text-sm text-gray-500">
                    {job.company} — {job.location}
                  </p>
                </div>
                <span
                  className={`mt-2 sm:mt-0 inline-block text-xs px-2 py-1 rounded-full font-medium self-start ${
                    job.status === "Interview Scheduled"
                      ? "bg-blue-100 text-blue-700"
                      : "bg-yellow-100 text-yellow-700"
                  }`}
                >
                  {job.status}
                </span>
              </div>

              <div className="grid sm:grid-cols-2 md:grid-cols-3 gap-3 text-sm text-gray-700">
                <div>
                  <span className="font-medium text-gray-600">Skills:</span>{" "}
                  {job.skills}
                </div>
                <div>
                  <span className="font-medium text-gray-600">Type:</span>{" "}
                  {job.type}
                </div>
                <div>
                  <span className="font-medium text-gray-600">Salary:</span>{" "}
                  {job.salary}
                </div>
                <div>
                  <span className="font-medium text-gray-600">Applied:</span>{" "}
                  {job.date}
                </div>
              </div>
            </div>
          ))}
      </div>
    </section>
  </main>
);


}
