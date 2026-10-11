import { useState } from 'react';
import { Menu, X } from 'lucide-react';
import { profile } from '../data/profile.js';

const links = ['about', 'skills', 'experience', 'projects', 'education', 'resume', 'contact'];

export default function Navbar() {
  const [open, setOpen] = useState(false);
  return (
    <header className="nav">
      <div className="container nav-inner">
        <a href="#top" className="brand">{profile.name}</a>
        <button className="nav-toggle" aria-label="Toggle menu" aria-expanded={open} onClick={() => setOpen(!open)}>
          {open ? <X size={22} /> : <Menu size={22} />}
        </button>
        <nav className={`nav-links ${open ? 'open' : ''}`} aria-label="Main">
          {links.map((l) => (
            <a key={l} href={`#${l}`} onClick={() => setOpen(false)}>
              {l.charAt(0).toUpperCase() + l.slice(1)}
            </a>
          ))}
        </nav>
      </div>
    </header>
  );
}
