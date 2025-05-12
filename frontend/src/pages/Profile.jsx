import { useState } from "react";
import EditProfileModal from "../components/EditProfileModal";
import PostJobModal from "../components/PostJobModal";

// const user = {
//   type: "user",
//   name: "John Doe",
//   email: "john@example.com",
//   phone: "+1 234 567 890",
//   location: "Bucharest",
//   lastJob: "Frontend Developer at TechCorp",
//   about:
//     "A highly motivated developer with 3+ years of experience in building responsive and accessible web applications.",
//   skills: [
//     "JavaScript / TypeScript",
//     "React.js / Vue.js",
//     "HTML5 / CSS3 / SASS",
//     "Git, REST APIs, Agile",
//   ],
//   education: "BSc in Computer Science, University of Webville (2017–2020)",
//   experience: {
//     role: "Frontend Developer",
//     company: "TechCorp",
//     period: "2020–2023",
//     description:
//       "Worked on responsive web apps and internal tools using React and REST APIs.",
//   },
//   avatar: "https://i.pravatar.cc/140?img=11",
//   social: {
//     linkedin: "https://linkedin.com/in/johndoe",
//     github: "https://github.com/johndoe",
//     twitter: "",
//     facebook: "",
//   },
// };

// Example company user
const user = {
  type: "company",
  name: "Acme Inc.",
  avatar: "https://i.pravatar.cc/300?u=company",
  location: "Berlin, Germany",
  industry: "Software Development",
  founded: 2010,
  employees: 150,
  about:
    "Acme Inc. builds scalable, cloud-based platforms for enterprises worldwide. Our mission is to simplify tech infrastructure so companies can focus on what matters most — their customers.",
  website: "https://acme.com",
  social: {
    linkedin: "https://linkedin.com/company/acme",
    twitter: "https://twitter.com/acme",
    facebook: "", // Empty = will not show
    github: "", // Optional
  },
  contact: {
    email: "contact@acme.com",
    phone: "+49 123 4567890",
  },
  leadership: {
    CEO: "Jane Smith",
    CTO: "Mark Johnson",
  },
  jobs: [
    { title: "Frontend Developer", type: "Full-Time", location: "Berlin" },
    { title: "Backend Engineer", type: "Contract", location: "Remote" },
    { title: "Product Manager", type: "Full-Time", location: "Berlin" },
  ],
};

export default function ProfilePage() {
  const [isEditing, setIsEditing] = useState(false);
  const [isPosting, setIsPosting] = useState(false);
  const [formData, setFormData] = useState({ ...user });

  return (
    <>
      <main className="max-w-4xl mx-auto px-4 py-8 text-gray-800 pt-16">
        <section className="flex flex-col sm:flex-row sm:items-start items-center text-center sm:text-left gap-6 border-b pb-6 mb-6">
          <img
            src={user.avatar}
            alt="Avatar"
            className="w-32 h-32 sm:w-40 sm:h-40 rounded-full object-cover border-4 border-blue-500 shadow"
          />
          <div className="flex-1 space-y-2">
            <h1 className="text-2xl font-bold">{user.name}</h1>

            {user.type === "company" ? (
              <>
                <p>
                  <strong className="text-gray-700">Location:</strong>{" "}
                  {user.location}
                </p>
                <p>
                  <strong className="text-gray-700">Industry:</strong>{" "}
                  {user.industry}
                </p>
                <p>
                  <strong className="text-gray-700">Founded:</strong>{" "}
                  {user.founded}
                </p>
                <p>
                  <strong className="text-gray-700">Employees:</strong>{" "}
                  {user.employees}
                </p>
              </>
            ) : (
              <>
                <p>
                  <strong className="text-gray-700">Email:</strong> {user.email}
                </p>
                <p>
                  <strong className="text-gray-700">Phone:</strong> {user.phone}
                </p>
                <p>
                  <strong className="text-gray-700">Last Job:</strong>{" "}
                  {user.lastJob}
                </p>
                <p>
                  <strong className="text-gray-700">Location:</strong>{" "}
                  {user.location}
                </p>
              </>
            )}

            <div className="flex gap-3 flex-wrap sm:flex-nowrap mt-3">
              <button
                onClick={() => setIsEditing(true)}
                className="bg-blue-500 hover:bg-blue-600 text-white py-2 px-4 text-sm rounded transition"
              >
                Edit Profile
              </button>
              {user.type === "company" && (
                <button
                  onClick={() => setIsPosting(true)}
                  className="bg-green-500 hover:bg-green-600 text-white py-2 px-4 text-sm rounded transition"
                >
                  Post Job
                </button>
              )}
            </div>
          </div>
        </section>

        <section className="mb-6">
          <h2 className="text-xl font-semibold border-b-2 border-blue-400 inline-block mb-2">
            About
          </h2>
          <p className="text-sm text-gray-700">{user.about}</p>
        </section>

        <section className="mb-6">
          <h2 className="text-xl font-semibold border-b-2 border-blue-400 inline-block mb-2">
            Social Profiles
          </h2>
          <div className="space-y-1 text-sm text-gray-700">
            {user.social.linkedin && (
              <p>
                <strong>LinkedIn:</strong>{" "}
                <a
                  className="text-blue-600"
                  href={user.social.linkedin}
                  target="_blank"
                  rel="noreferrer"
                >
                  {user.social.linkedin}
                </a>
              </p>
            )}
            {user.social.github && (
              <p>
                <strong>GitHub:</strong>{" "}
                <a
                  className="text-blue-600"
                  href={user.social.github}
                  target="_blank"
                  rel="noreferrer"
                >
                  {user.social.github}
                </a>
              </p>
            )}
            {user.social.twitter && (
              <p>
                <strong>Twitter:</strong>{" "}
                <a
                  className="text-blue-600"
                  href={user.social.twitter}
                  target="_blank"
                  rel="noreferrer"
                >
                  {user.social.twitter}
                </a>
              </p>
            )}
            {user.social.facebook && (
              <p>
                <strong>Facebook:</strong>{" "}
                <a
                  className="text-blue-600"
                  href={user.social.facebook}
                  target="_blank"
                  rel="noreferrer"
                >
                  {user.social.facebook}
                </a>
              </p>
            )}
          </div>
        </section>

        {user.type === "user" && (
          <>
            <section className="mb-6">
              <h2 className="text-xl font-semibold border-b-2 border-blue-400 inline-block mb-2">
                Skills
              </h2>
              <ul className="list-disc list-inside text-sm text-gray-700 grid grid-cols-1 sm:grid-cols-2 gap-1">
                {user.skills.map((skill) => (
                  <li key={skill}>{skill}</li>
                ))}
              </ul>
            </section>

            <section className="mb-6">
              <h2 className="text-xl font-semibold border-b-2 border-blue-400 inline-block mb-2">
                Education
              </h2>
              <p className="text-sm text-gray-700">{user.education}</p>
            </section>

            <section>
              <h2 className="text-xl font-semibold border-b-2 border-blue-400 inline-block mb-2">
                Experience
              </h2>
              <p className="text-sm font-semibold text-gray-800">
                {user.experience.role} – {user.experience.company} (
                {user.experience.period})
              </p>
              <p className="text-sm text-gray-700">
                {user.experience.description}
              </p>
            </section>
          </>
        )}

        {user.type === "company" && (
          <>
            <section className="mb-6">
              <h2 className="text-xl font-semibold border-b-2 border-blue-400 inline-block mb-2">
                Online Presence
              </h2>
              <p className="text-sm text-gray-700">
                <strong>Website:</strong>{" "}
                <a
                  className="text-blue-600"
                  href={user.website}
                  target="_blank"
                  rel="noreferrer"
                >
                  {user.website}
                </a>
              </p>
              <p className="text-sm text-gray-700">
                <strong>Social:</strong>{" "}
                <a className="text-blue-600" href={user.social.linkedin}>
                  LinkedIn
                </a>{" "}
                |{" "}
                <a className="text-blue-600" href={user.social.twitter}>
                  Twitter
                </a>
              </p>
            </section>

            <section className="mb-6">
              <h2 className="text-xl font-semibold border-b-2 border-blue-400 inline-block mb-2">
                Contact
              </h2>
              <p className="text-sm text-gray-700">
                Email: {user.contact.email}
              </p>
              <p className="text-sm text-gray-700">
                Phone: {user.contact.phone}
              </p>
            </section>

            <section className="mb-6">
              <h2 className="text-xl font-semibold border-b-2 border-blue-400 inline-block mb-2">
                Leadership
              </h2>
              <p className="text-sm text-gray-700">
                <strong>CEO:</strong> {user.leadership.CEO}
              </p>
              <p className="text-sm text-gray-700">
                <strong>CTO:</strong> {user.leadership.CTO}
              </p>
            </section>

            <section>
              <h2 className="text-xl font-semibold border-b-2 border-blue-400 inline-block mb-2">
                Job Listings
              </h2>
              <div className="h-64 overflow-y-auto pr-1">
                {user.jobs.map((job, index) => (
                  <div
                    key={`${job.title}-${index}`}
                    className="flex justify-between items-center border p-3 rounded mb-2 text-sm"
                  >
                    <div>
                      <strong>{job.title}</strong>
                      <div className="text-gray-600">
                        {job.type} · {job.location}
                      </div>
                    </div>
                    <div className="space-x-2">
                      <button className="text-red-600 hover:underline">
                        Delete
                      </button>
                    </div>
                  </div>
                ))}
              </div>
            </section>
          </>
        )}
      </main>

      {isEditing && (
        <EditProfileModal
          formData={formData}
          setFormData={setFormData}
          onClose={() => setIsEditing(false)}
        />
      )}

      {isPosting && <PostJobModal onClose={() => setIsPosting(false)} />}
    </>
  );
}
