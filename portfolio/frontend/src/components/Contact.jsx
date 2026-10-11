import { useState } from 'react';
import { Send } from 'lucide-react';
import { sendContact } from '../services/api.js';

const empty = { name: '', email: '', subject: '', message: '', website: '' };

function validate(f) {
  const e = {};
  if (f.name.trim().length < 2) e.name = 'Please enter your name (min 2 characters).';
  if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(f.email)) e.email = 'Please enter a valid email.';
  if (f.subject.trim().length < 3) e.subject = 'Subject must be at least 3 characters.';
  if (f.message.trim().length < 10) e.message = 'Message must be at least 10 characters.';
  return e;
}

export default function Contact() {
  const [form, setForm] = useState(empty);
  const [errors, setErrors] = useState({});
  const [status, setStatus] = useState({ type: '', text: '' });
  const [sending, setSending] = useState(false);

  const onChange = (e) => setForm({ ...form, [e.target.name]: e.target.value });

  async function onSubmit(e) {
    e.preventDefault();
    const v = validate(form);
    setErrors(v);
    if (Object.keys(v).length) return;
    setSending(true);
    setStatus({ type: '', text: '' });
    try {
      const res = await sendContact(form);
      setStatus({ type: 'success', text: res.message });
      setForm(empty);
    } catch (err) {
      setErrors(err.fieldErrors || {});
      setStatus({ type: 'error', text: err.status === 429 ? err.message : 'Could not send your message. Please try again.' });
    } finally {
      setSending(false);
    }
  }

  const field = (name, label, props = {}) => (
    <div className="field">
      <label htmlFor={name}>{label}</label>
      {props.textarea ? (
        <textarea id={name} name={name} rows="5" value={form[name]} onChange={onChange}
          aria-invalid={!!errors[name]} aria-describedby={`${name}-err`} maxLength="3000" />
      ) : (
        <input id={name} name={name} type={props.type || 'text'} value={form[name]} onChange={onChange}
          aria-invalid={!!errors[name]} aria-describedby={`${name}-err`} maxLength="200" />
      )}
      <span id={`${name}-err`} className="field-error">{errors[name]}</span>
    </div>
  );

  return (
    <section id="contact" className="section container">
      <h2 className="section-title">Contact Me</h2>
      <form className="card form" onSubmit={onSubmit} noValidate>
        {field('name', 'Name')}
        {field('email', 'Email', { type: 'email' })}
        {field('subject', 'Subject')}
        {field('message', 'Message', { textarea: true })}
        {/* Honeypot: hidden from humans and assistive tech; bots tend to fill it */}
        <div className="hp" aria-hidden="true">
          <label htmlFor="website">Website</label>
          <input id="website" name="website" tabIndex="-1" autoComplete="off" value={form.website} onChange={onChange} />
        </div>
        <button className="btn primary" type="submit" disabled={sending}>
          <Send size={18} /> {sending ? 'Sending…' : 'Send Message'}
        </button>
        {status.text && <p role="status" className={`msg ${status.type}`}>{status.text}</p>}
      </form>
    </section>
  );
}
