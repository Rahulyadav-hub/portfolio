import { profile } from '../data/profile.js';

export default function About() {
  return (
    <section id="about" className="section container">
      <h2 className="section-title">About Me</h2>
      <div className="card">
        {profile.about.map((p, i) => <p key={i}>{p}</p>)}
      </div>
    </section>
  );
}
