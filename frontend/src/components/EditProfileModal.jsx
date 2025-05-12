
export default function EditProfileModal({ formData, setFormData, onClose }) {
  return (
    <div className="fixed inset-0 bg-black/50 flex items-center justify-center z-50">
      <div className="bg-white rounded-lg shadow-lg p-6 w-full max-w-lg max-h-[90vh] overflow-y-auto relative">
        <h2 className="text-xl font-semibold mb-4">Edit Profile</h2>

        <div className="space-y-4 text-sm">
          <div>
            <label className="block font-semibold">Name</label>
            <input
              value={formData.name}
              onChange={(e) =>
                setFormData({ ...formData, name: e.target.value })
              }
              className="w-full border p-2 rounded"
            />
          </div>

          {formData.type === "user" && (
            <>
              <Input
                label="Email"
                value={formData.email}
                onChange={(v) => setFormData({ ...formData, email: v })}
              />
              <Input
                label="Phone"
                value={formData.phone}
                onChange={(v) => setFormData({ ...formData, phone: v })}
              />
              <Input
                label="Last Job"
                value={formData.lastJob}
                onChange={(v) => setFormData({ ...formData, lastJob: v })}
              />
              <Input
                label="Location"
                value={formData.location}
                onChange={(v) => setFormData({ ...formData, location: v })}
              />
              <Textarea
                label="About"
                value={formData.about}
                onChange={(v) => setFormData({ ...formData, about: v })}
              />
              <Textarea
                label="Skills (comma separated)"
                value={formData.skills?.join(", ") || ""}
                onChange={(v) =>
                  setFormData({
                    ...formData,
                    skills: v.split(",").map((s) => s.trim()),
                  })
                }
              />
              <Input
                label="Education"
                value={formData.education}
                onChange={(v) => setFormData({ ...formData, education: v })}
              />
              <Input
                label="Experience Role"
                value={formData.experience?.role || ""}
                onChange={(v) =>
                  setFormData({
                    ...formData,
                    experience: { ...formData.experience, role: v },
                  })
                }
              />
              <Input
                label="Experience Company"
                value={formData.experience?.company || ""}
                onChange={(v) =>
                  setFormData({
                    ...formData,
                    experience: { ...formData.experience, company: v },
                  })
                }
              />
              <Input
                label="Experience Period"
                value={formData.experience?.period || ""}
                onChange={(v) =>
                  setFormData({
                    ...formData,
                    experience: { ...formData.experience, period: v },
                  })
                }
              />
              <Textarea
                label="Experience Description"
                value={formData.experience?.description || ""}
                onChange={(v) =>
                  setFormData({
                    ...formData,
                    experience: { ...formData.experience, description: v },
                  })
                }
              />
              <Textarea
                label="LinkedIn"
                value={formData.social?.linkedin || ""}
                onChange={(v) =>
                  setFormData({
                    ...formData,
                    social: { ...formData.social, linkedin: v },
                  })
                }
              />
              <Textarea
                label="Twitter"
                value={formData.social?.twitter || ""}
                onChange={(v) =>
                  setFormData({
                    ...formData,
                    social: { ...formData.social, twitter: v },
                  })
                }
              />
              <Textarea
                label="Facebook"
                value={formData.social?.facebook || ""}
                onChange={(v) =>
                  setFormData({
                    ...formData,
                    social: { ...formData.social, facebook: v },
                  })
                }
              />
              <Textarea
                label="GitHub"
                value={formData.social?.github || ""}
                onChange={(v) =>
                  setFormData({
                    ...formData,
                    social: { ...formData.social, github: v },
                  })
                }
              />
            </>
          )}

          {formData.type === "company" && (
            <>
              <Input
                label="Location"
                value={formData.location}
                onChange={(v) => setFormData({ ...formData, location: v })}
              />
              <Input
                label="Industry"
                value={formData.industry}
                onChange={(v) => setFormData({ ...formData, industry: v })}
              />
              <Input
                label="Founded"
                value={formData.founded}
                onChange={(v) => setFormData({ ...formData, founded: v })}
              />
              <Input
                label="Employees"
                value={formData.employees}
                onChange={(v) => setFormData({ ...formData, employees: v })}
              />
              <Textarea
                label="About"
                value={formData.about}
                onChange={(v) => setFormData({ ...formData, about: v })}
              />
              <Input
                label="Website"
                value={formData.website}
                onChange={(v) => setFormData({ ...formData, website: v })}
              />
              <Input
                label="Email"
                value={formData.contact?.email || ""}
                onChange={(v) =>
                  setFormData({
                    ...formData,
                    contact: { ...formData.contact, email: v },
                  })
                }
              />
              <Input
                label="Phone"
                value={formData.contact?.phone || ""}
                onChange={(v) =>
                  setFormData({
                    ...formData,
                    contact: { ...formData.contact, phone: v },
                  })
                }
              />
              <Input
                label="CEO"
                value={formData.leadership?.CEO || ""}
                onChange={(v) =>
                  setFormData({
                    ...formData,
                    leadership: { ...formData.leadership, CEO: v },
                  })
                }
              />
              <Input
                label="CTO"
                value={formData.leadership?.CTO || ""}
                onChange={(v) =>
                  setFormData({
                    ...formData,
                    leadership: { ...formData.leadership, CTO: v },
                  })
                }
              />
              <Textarea
                label="LinkedIn"
                value={formData.social?.linkedin || ""}
                onChange={(v) =>
                  setFormData({
                    ...formData,
                    social: { ...formData.social, linkedin: v },
                  })
                }
              />
              <Textarea
                label="Twitter"
                value={formData.social?.twitter || ""}
                onChange={(v) =>
                  setFormData({
                    ...formData,
                    social: { ...formData.social, twitter: v },
                  })
                }
              />
              <Textarea
                label="Facebook"
                value={formData.social?.facebook || ""}
                onChange={(v) =>
                  setFormData({
                    ...formData,
                    social: { ...formData.social, facebook: v },
                  })
                }
              />
              <Textarea
                label="GitHub"
                value={formData.social?.github || ""}
                onChange={(v) =>
                  setFormData({
                    ...formData,
                    social: { ...formData.social, github: v },
                  })
                }
              />
            </>
          )}
        </div>

        <div className="flex justify-end gap-2 mt-6">
          <button
            className="bg-gray-300 hover:bg-gray-400 text-gray-800 py-2 px-4 rounded"
            onClick={onClose}
          >
            Cancel
          </button>
          <button
            className="bg-blue-500 hover:bg-blue-600 text-white py-2 px-4 rounded"
            onClick={() => {
              console.log("Saved data:", formData);
              onClose();
            }}
          >
            Save
          </button>
        </div>
      </div>
    </div>
  );
}

function Input({ label, value, onChange }) {
  return (
    <div>
      <label className="block font-semibold">{label}</label>
      <input
        value={value}
        onChange={(e) => onChange(e.target.value)}
        className="w-full border p-2 rounded"
      />
    </div>
  );
}

function Textarea({ label, value, onChange }) {
  return (
    <div>
      <label className="block font-semibold">{label}</label>
      <textarea
        value={value}
        onChange={(e) => onChange(e.target.value)}
        className="w-full border p-2 rounded min-h-[100px]"
      />
    </div>
  );
}
