const BASE = (import.meta.env.VITE_API_BASE_URL || 'http://localhost:8080').replace(/\/$/, '');

async function request(path, options = {}) {
  const res = await fetch(`${BASE}${path}`, {
    headers: { 'Content-Type': 'application/json' },
    ...options,
  });
  const body = res.status === 204 ? null : await res.json().catch(() => null);
  if (!res.ok) {
    const err = new Error(body?.error || `Request failed (${res.status})`);
    err.fieldErrors = body?.fieldErrors || {};
    err.status = res.status;
    throw err;
  }
  return body;
}

export const getProjects = () => request('/api/projects');
export const getSkills = () => request('/api/skills');
export const sendContact = (data) => request('/api/contact', { method: 'POST', body: JSON.stringify(data) });
