// All editable portfolio content lives here. Only facts you provided are included.
export const profile = {
  name: 'Rahul Yadav',
  title: 'Java Full Stack Developer',
  intro:
    'Java Full Stack Developer with 3 years of experience building scalable microservices and REST APIs with Spring Boot, Spring Cloud and AWS. Immediate joiner.',
  availability: 'Immediate joiner',
  resumeFile: '/Rahul_Yadav_Resume_J.pdf',
  email: 'rahulydv5335@gmail.com',
  linkedin: 'https://www.linkedin.com/in/rahul-yadav-3241731b2/',
  github: 'https://github.com/Rahulyadav-hub',
  about: [
    'I am a Java Full Stack Developer with nearly 3 years of experience in Java, Spring Boot, Microservices, REST APIs, JPA/Hibernate, and SQL. I also have experience with React, Angular, JavaScript, HTML, and CSS for frontend development.',
    'At LTIMindtree, I worked on enterprise applications, including the Tanishq NAP application for Titan. My responsibilities included developing backend services, migrating legacy Struts modules to Spring Boot microservices, integrating REST APIs, and supporting frontend development.',
    'I have also worked with AWS, Docker, Jenkins, JUnit, and Mockito. I enjoy solving technical problems, troubleshooting production issues, and building scalable, maintainable applications.',
  ],
  experience: [
    {
      company: 'Personal Development',
      role: 'Upskilling & Project Work',
      period: 'Dec 2025 – Present',
      project: 'Order Management Microservices',
      responsibilities: [
        'Completed a Java Full Stack Development course (Oct 2025 – Mar 2026) covering Spring Boot, Microservices and REST APIs.',
        'Built Order, Inventory and Notification Spring Boot microservices communicating via Feign client.',
        'Secured APIs with JWT authentication, documented them using Swagger, and added unit tests with JUnit and Mockito.',
      ],
      technologies: ['Java 11', 'Spring Boot', 'Feign', 'MySQL', 'Docker'],
    },
    {
      company: 'LTIMindtree, Bengaluru',
      role: 'Software Engineer',
      period: 'Nov 2022 – Nov 2025',
      project: 'Tanishq NAP Application (Titan)',
      responsibilities: [
        'Designed and developed end-to-end RESTful APIs to synchronize master data across 600+ retail stores, ensuring seamless data flow between centralized and store-level systems.',
        'Built asynchronous, scalable data communication by publishing messages to AWS SQS and SNS queues via existing data sync services.',
        'Led migration of legacy Struts-based modules to Spring Boot microservices, while maintaining and enhancing existing functionality.',
        'Partnered directly with the client onsite to troubleshoot and resolve urgent production issues during high-traffic festival periods.',
        'Integrated Feign client for reliable inter-service communication across microservices.',
        'Automated build and deployment pipelines using Jenkins CI/CD, improving delivery speed.',
        'Resolved critical backend bugs and feature requests, achieving a 40% reduction in recurring support tickets.',
      ],
      technologies: ['Java', 'Spring Boot','Microservices', 'Angular', 'Struts', 'Feign', 'AWS SQS/SNS', 'Jenkins', 'SQL Server'],
    },
    {
      company: 'LTIMindtree, Bengaluru',
      role: 'Software Engineer',
      period: 'Jun 2022 – Nov 2022',
      project: 'AAMC Modernized MDA Portal',
      responsibilities: [
        'Supported a Java Spring Boot microservices platform powering education management for medical institutions across the US.',
        'Authored unit tests with JUnit 4 and Mockito, achieving over 90% code coverage on critical backend services.',
        'Participated in client meetings to present fixes, gather requirements, and translate feedback into development tasks.',
      ],
      technologies: ['Java', 'Spring Boot', 'Microservices', 'JUnit 4', 'Mockito'],
    },
  ],
  education: [
    {
      degree: 'Bachelor of Technology, Computer Science and Engineering',
      institution: 'Uttarakhand Technical University, Dehradun, Uttarakhand',
      period: 'May 2017 – Jun 2021',
    },
  ],
  certifications: [
    'Java Full Stack Development Course (Oct 2025 – Mar 2026)',
    'Java 8 New Features in Simple Way — Udemy',
    'Master Microservices with Spring Boot and Spring Cloud — Udemy',
  ],
};