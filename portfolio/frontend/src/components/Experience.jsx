import { profile } from '../data/profile.js';

export default function Experience() {
  return (
    <section id="experience" className="section container">
      <h2 className="section-title">Work Experience</h2>
      {profile.experience.map((e) => (
        <article className="card" key={e.company}>
          <h3>{e.role} <span className="muted">· {e.company}</span></h3>
          {e.period && <p className="muted">{e.period}</p>}
          <p><strong>Project:</strong> {e.project}</p>
          <ul className="list">{e.responsibilities.map((r, i) => <li key={i}>{r}</li>)}</ul>
          <ul className="chips">{e.technologies.map((t) => <li key={t}>{t}</li>)}</ul>
        </article>
      ))}
    </section>
  );
}
