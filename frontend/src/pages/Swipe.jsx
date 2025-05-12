import { useState, useRef } from "react";
import SwipeCard from "../components/SwipeCard";

const jobs = [
{
  id: 101,
  title: "Senior Frontend Engineer",
  company: "InnovateX Technologies",
  location: "Berlin, Germany (Remote-friendly)",
  type: "Full-Time",
  salary: "€70,000 – €90,000/year",
  level: "Senior",
  postedDate: "2025-05-10",
  techStack: ["React", "TypeScript", "TailwindCSS", "Jest"],
  description: `
InnovateX is seeking a highly skilled Senior Frontend Engineer to lead the development of new features and user interfaces for our analytics SaaS platform. You'll collaborate with product managers, designers, and backend engineers to deliver polished, responsive, and accessible experiences.

### Key Responsibilities:
- Design and implement complex user interfaces using React and modern front-end technologies
- Maintain a scalable design system and component library
- Ensure high accessibility standards (a11y) and cross-browser compatibility
- Write clean, testable code and mentor junior developers
- Participate in architecture discussions and product planning

### Required Qualifications:
- 4+ years of professional experience with modern JavaScript (ES6+), HTML, and CSS
- Strong expertise in React and state management (e.g. Redux, Zustand)
- Proficient in TypeScript and frontend testing (Jest, React Testing Library)
- Experience working in agile teams and Git-based workflows
- Strong understanding of web performance and accessibility

### Nice to Have:
- Familiarity with TailwindCSS and Storybook
- Experience with internationalization (i18n)
- Familiarity with CI/CD pipelines

---

**Start Date:** Immediate  
**Contract Type:** Permanent, Full-Time  
**Remote Policy:** Remote within CET ±2h  
**Perks:** Flexible hours, annual learning budget, equipment stipend, wellness allowance
`,
},
{
  id: 102,
  title: "Backend Engineer",
  company: "DataWave Systems",
  location: "Remote (EU preferred)",
  type: "Full-Time",
  salary: "€65,000 – €85,000/year",
  level: "Mid-Senior",
  postedDate: "2025-05-09",
  techStack: ["Node.js", "PostgreSQL", "Docker", "AWS", "Redis"],
  description: `
DataWave Systems is looking for a talented Backend Engineer to help us scale and optimize our cloud-based data pipeline infrastructure. You'll play a key role in designing APIs, managing databases, and ensuring service reliability across our platform.

### Key Responsibilities:
- Develop and maintain RESTful APIs using Node.js and Express
- Design and optimize relational database schemas (PostgreSQL)
- Implement caching and message queues (Redis, RabbitMQ)
- Monitor, test, and improve performance and scalability
- Collaborate closely with DevOps, Frontend, and Product teams

### Required Qualifications:
- 3+ years experience with server-side development in Node.js
- Strong knowledge of SQL databases and query optimization
- Experience with Docker and cloud environments (AWS or GCP)
- Familiarity with testing frameworks (e.g. Mocha, Chai, Jest)
- Git and Agile team experience

### Nice to Have:
- Experience with GraphQL or gRPC APIs
- Infrastructure as Code (Terraform, CloudFormation)
- Basic understanding of frontend or mobile integrations

---

**Start Date:** ASAP  
**Contract Type:** Full-Time, Remote  
**Time Zone Overlap:** At least 4 hours with CET  
**Perks:** Annual bonus, home office stipend, monthly team budget, wellness Fridays
`,
},
{
  id: 103,
  title: "Backend Engineer",
  company: "DataWave Systems",
  location: "Remote (EU preferred)",
  type: "Full-Time",
  salary: "€65,000 – €85,000/year",
  level: "Mid-Senior",
  postedDate: "2025-05-09",
  techStack: ["Node.js", "PostgreSQL", "Docker", "AWS", "Redis"],
  description: `
DataWave Systems is looking for a talented Backend Engineer to help us scale and optimize our cloud-based data pipeline infrastructure. You'll play a key role in designing APIs, managing databases, and ensuring service reliability across our platform.

### Key Responsibilities:
- Develop and maintain RESTful APIs using Node.js and Express
- Design and optimize relational database schemas (PostgreSQL)
- Implement caching and message queues (Redis, RabbitMQ)
- Monitor, test, and improve performance and scalability
- Collaborate closely with DevOps, Frontend, and Product teams

### Required Qualifications:
- 3+ years experience with server-side development in Node.js
- Strong knowledge of SQL databases and query optimization
- Experience with Docker and cloud environments (AWS or GCP)
- Familiarity with testing frameworks (e.g. Mocha, Chai, Jest)
- Git and Agile team experience

### Nice to Have:
- Experience with GraphQL or gRPC APIs
- Infrastructure as Code (Terraform, CloudFormation)
- Basic understanding of frontend or mobile integrations

---

**Start Date:** ASAP  
**Contract Type:** Full-Time, Remote  
**Time Zone Overlap:** At least 4 hours with CET  
**Perks:** Annual bonus, home office stipend, monthly team budget, wellness Fridays
`,
}
];

export default function Swipe() {
  const [visibleCards, setVisibleCards] = useState(jobs);
  const [swipeDelta, setSwipeDelta] = useState(0);

  const handleSwipeComplete = () => {
    setSwipeDelta(0);
    setVisibleCards((prev) => prev.slice(1));
  };

  return (
    <div className="relative w-full h-screen flex items-center justify-center bg-gray-100 overflow-hidden">
      {/* Glows */}
      <div
        className="absolute left-0 top-0 h-full w-1/2 pointer-events-none z-0"
        style={{
          background: "linear-gradient(to right, rgba(239, 68, 68, 0.4), transparent)",
          opacity: Math.min(Math.abs(swipeDelta) / 150, 1) * (swipeDelta < 0 ? 1 : 0),
          transition: "opacity 0.1s linear",
        }}
      />
      <div
        className="absolute right-0 top-0 h-full w-1/2 pointer-events-none z-0"
        style={{
          background: "linear-gradient(to left, rgba(34, 197, 94, 0.4), transparent)",
          opacity: Math.min(Math.abs(swipeDelta) / 150, 1) * (swipeDelta > 0 ? 1 : 0),
          transition: "opacity 0.1s linear",
        }}
      />

      <div className="relative w-[90vw] max-w-md h-[70vh] z-10">
        {visibleCards.length === 0 && (
          <div className="flex justify-center items-center h-full text-gray-500">
            <h2>No more jobs</h2>
          </div>
        )}

        {visibleCards.map((job, i) => (
          <SwipeCard
            key={job.id}
            job={job}
            onSwipeComplete={handleSwipeComplete}
            isTop={i === 0}
            onSwipeMove={i === 0 ? setSwipeDelta : () => {}}
          />
        ))}
      </div>
    </div>
  );
}