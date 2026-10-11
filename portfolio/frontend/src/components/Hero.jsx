import { Download, FolderGit2, Github, Linkedin, Mail } from 'lucide-react';
import { profile } from '../data/profile.js';

export default function Hero() {
  return (
    <section id="top" className="hero container">
      <div className="hero-text">
        <p className="badge">{profile.availability}</p>
        <h1>Hi, I'm <span className="accent">{profile.name}</span></h1>
        <h2>{profile.title}</h2>

        <div className="socials">
          <a href={profile.linkedin} target="_blank" rel="noreferrer" aria-label="LinkedIn">
            <Linkedin size={22} /> <span>LinkedIn</span>
          </a>
          <a href={profile.github} target="_blank" rel="noreferrer" aria-label="GitHub">
            <Github size={22} /> <span>GitHub</span>
          </a>
          <div className="social-mail">
            <Mail size={22} /> <span>Gmail: {profile.email}</span>
          </div>
        </div>

        <p className="lead">{profile.intro}</p>
        <div className="btn-row">
          <a className="btn primary" href="#projects"><FolderGit2 size={18} /> View Projects</a>
          <a className="btn" href={profile.resumeFile} download><Download size={18} /> Download Resume</a>
          <a className="btn" href="#contact"><Mail size={18} /> Contact Me</a>
        </div>
      </div>
      <div className="hero-photo">
        <img src="/profile.jpg" alt="Rahul Yadav" />
      </div>
    </section>
  );
}