import { Download } from 'lucide-react';
import { profile } from '../data/profile.js';

export default function Resume() {
  return (
    <section id="resume" className="section container">
      <h2 className="section-title">Resume</h2>
      <div className="card center">
        <p>Download my latest resume as a PDF.</p>
        <a className="btn primary" href={profile.resumeFile} download><Download size={18} /> Download Resume</a>
      </div>
    </section>
  );
}
