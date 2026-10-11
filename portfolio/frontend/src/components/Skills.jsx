import { useEffect, useState } from 'react';
import { getSkills } from '../services/api.js';

export default function Skills() {
  const [skills, setSkills] = useState([]);
  const [error, setError] = useState('');

  useEffect(() => {
    getSkills().then(setSkills).catch(() => setError('Could not load skills right now.'));
  }, []);

  const groups = skills.reduce((acc, s) => {
    (acc[s.category] = acc[s.category] || []).push(s.name);
    return acc;
  }, {});

  return (
    <section id="skills" className="section container">
      <h2 className="section-title">Technical Skills</h2>
      {error && <p className="msg error" role="alert">{error}</p>}
      <div className="grid">
        {Object.entries(groups).map(([cat, names]) => (
          <div className="card" key={cat}>
            <h3>{cat}</h3>
            <ul className="chips">{names.map((n) => <li key={n}>{n}</li>)}</ul>
          </div>
        ))}
      </div>
    </section>
  );
}
