import { profile } from '../data/profile.js';

export default function Education() {
  return (
    <section id="education" className="section container">
      <h2 className="section-title">Education</h2>
      {profile.education.length === 0 ? (
        <div className="card"><p className="muted">Add your education details in <code>src/data/profile.js</code>.</p></div>
      ) : (
        profile.education.map((e, i) => (
          <div className="card" key={i}>
            <h3>{e.degree}</h3>
            <p>{e.institution}</p>
            <p className="muted">{e.period}</p>
          </div>
        ))
      )}
    </section>
  );
}
