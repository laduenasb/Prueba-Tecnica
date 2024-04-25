import React from 'react';
import './EmployeesTable.css' // Archivo de estilos de la tabla


export default function EmployeesTable({ employees, filterField, searchTerm }) {
  const filteredEmployees = employees.filter((employee) => {
    if (filterField === 'name') {
      return employee.name.toLowerCase().includes(searchTerm.toLowerCase());
    } else if (filterField === 'email') {
      return employee.email.toLowerCase().includes(searchTerm.toLowerCase());
    } else if (filterField === 'city') {
      return employee.address.city.toLowerCase().includes(searchTerm.toLowerCase());
    }
    return true; // Mostrar todos si no hay filtro aplicado
  });

  return (
    <div>
      <table className='filteredTable'>
        <thead>
          <tr>
            <th>Name</th>
            <th>Username</th>
            <th>Email</th>
            <th>Company</th>
            <th>City</th>
          </tr>
        </thead>
        <tbody>
          {filteredEmployees.map((employee) => (
            <tr key={employee.id}>
              <td>{employee.name}</td>
              <td>{employee.username}</td>
              <td>{employee.email}</td>
              <td>{employee.company.name}</td>
              <td>{employee.address.city}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
