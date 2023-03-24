INSERT INTO worker (name, birthday, level, salary)
VALUES
  ('John Smith', '1990-01-01', 'Trainee', 800),
  ('Emily Brown', '1993-02-15', 'Junior', 1200),
  ('Michael Davis', '1985-05-23', 'Middle', 3000),
  ('Jessica Wilson', '1991-12-05', 'Senior', 12500),
  ('William Thompson', '1995-07-11', 'Trainee', 900),
  ('Hannah Lee', '1989-06-18', 'Junior', 1500),
  ('David Miller', '1984-11-20', 'Middle', 4000),
  ('Olivia Garcia', '1992-08-08', 'Senior', 7000),
  ('Daniel Robinson', '1996-04-02', 'Trainee', 1000),
  ('Sophia Rodriguez', '1990-03-29', 'Junior', 1300),
  ('Elizabeth Scott', '1986-09-14', 'Middle', 3500),
  ('Isabella Wright', '1994-11-30', 'Senior', 8000),
  ('James Baker', '1998-05-06', 'Trainee', 700),
  ('Victoria Green', '1988-07-27', 'Junior', 1100),
  ('Christopher Adams', '1983-12-17', 'Middle', 2800),
  ('Grace King', '1983-10-08', 'Senior', 5500),
  ('Robert Baker', '1997-09-13', 'Trainee', 950),
  ('Audrey Evans', '1992-06-01', 'Junior', 1400),
  ('Thomas Flores', '1985-01-30', 'Middle', 3200),
  ('Madison Cooper', '1993-11-10', 'Senior', 6500),
  ('Matthew Young', '1999-03-22', 'Trainee', 850),
  ('Ava Hill', '1987-02-14', 'Junior', 1250),
  ('Liam Allen', '1984-09-06', 'Middle', 3700),
  ('Ella Torres', '1991-05-19', 'Senior', 14500),
  ('Christopher Campbell', '1995-08-29', 'Trainee', 800),
  ('Sofia Parker', '1989-07-02', 'Junior', 1350),
  ('Ryan Wright', '1999-03-22', 'Middle', 2900),
  ('Scarlett Mitchell', '1994-12-26', 'Senior', 9000),
  ('David Perez', '1999-03-22', 'Trainee', 600),
  ('Abigail Collins', '1992-04-05', 'Junior', 1000),
  ('Nicholas Turner', '1985-03-18', 'Middle', 3300);

INSERT INTO client (NAME) VALUES
('John Smith'),
('Emily Brown'),
('William Davis'),
('Ava Johnson'),
('Michael Wilson'),
('Sophia Taylor'),
('David Martin'),
('Emma Anderson'),
('Olivia Thompson'),
('Benjamin Garcia');

INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE)
VALUES
(1, '2022-01-01', '2022-02-01'),
(2, '2021-03-15', '2021-08-15'),
(3, '2023-05-01', '2024-05-01'),
(4, '2021-12-01', '2022-06-01'),
(5, '2022-06-01', '2023-01-01'),
(6, '2022-03-01', '2023-03-01'),
(7, '2023-01-01', '2023-12-01'),
(8, '2021-10-01', '2022-05-01'),
(9, '2022-09-01', '2023-08-01'),
(10, '2023-02-01', '2024-02-01'),
(1, '2022-03-01', '2022-08-01'),
(3, '2021-01-01', '2022-01-01'),
(3, '2023-06-01', '2024-01-01'),
(3, '2021-12-01', '2022-12-01'),
(5, '2022-07-01', '2023-05-01'),
(6, '2022-02-01', '2023-04-01'),
(7, '2023-03-01', '2024-03-01'),
(7, '2021-11-01', '2022-06-01'),
(7, '2022-10-01', '2023-09-01'),
(10, '2023-04-01', '2024-04-01');

INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
SELECT p.ID, w.ID
FROM project p
CROSS JOIN (
  SELECT ID
  FROM worker
  ORDER BY RAND()
  LIMIT 1 + CAST(RAND() * 5 AS INT)
) w
ORDER BY p.ID;


