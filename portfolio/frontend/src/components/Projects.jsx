import { useEffect, useState } from 'react';
import { ExternalLink, Github } from 'lucide-react';
import { getProjects } from '../services/api.js';

export default function Projects() {
  const [projects, setProjects] = useState([]);
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    getProjects()
      .then(setProjects)
      .catch(() => setError('Could not load projects right now.'))
      .finally(() => setLoading(false));
  }, []);

  return (
    <section id="projects" className="section container">
      <h2 className="section-title">Projects</h2>
      {loading && <p className="muted">Loading…</p>}
      {error && <p className="msg error" role="alert">{error}</p>}
      <div className="grid">
        {projects.map((p) => (
          <article className="card" key={p.id}>
            <p className="tag">{p.category === 'DEMO' ? 'Personal / Demo project' : 'Professional project'}</p>
            <h3>{p.name}</h3>
            <p>{p.description}</p>
            <ul className="chips">{p.technologies.split(',').map((t) => <li key={t}>{t.trim()}</li>)}</ul>
            <div className="links">
              {p.githubUrl && <a href={p.githubUrl} target="_blank" rel="noreferrer"><Github size={16} /> GitHub</a>}
              {p.liveUrl && <a href={p.liveUrl} target="_blank" rel="noreferrer"><ExternalLink size={16} /> Live demo</a>}
            </div>
          </article>
        ))}
      </div>
    </section>
  );
}
