import React, { useEffect, useState } from 'react'
import EmployeesTable from '../components/EmployeesTable'
import "./EmployeesDashboard.css" // Archivo de estilos del filtro


export default function EmployeesDashboard() {
  const [employees, setEmployees] = useState([])
  const [filterField, setFilterField] = useState('name'); // Campo inicial para filtrar (por nombre)
  const [searchTerm, setSearchTerm] = useState(''); // Término de búsqueda
  useEffect(()=>{
    const fetchEmployees = async ()=>{
      try {
        const response = await fetch("https://jsonplaceholder.typicode.com/users")
        const data = await response.json()
        console.log(data);
        setEmployees(data)
      } catch (error) {
        console.log("Error calling employees API", error)
      }
    }
    fetchEmployees()
  }, [])
  const handleFilterChange = (e) => {
    setFilterField(e.target.value);
  };

  const handleSearchChange = (e) => {
    setSearchTerm(e.target.value);
  };
  return (
    <div className='filter'>
      <h1>Employees List</h1>
      <div>
        <label htmlFor="filterField">Filter by:</label>
        <select id="filterField" value={filterField} onChange={handleFilterChange}>
          <option value="name">Name</option>
          <option value="email">Email</option>
          <option value="city">City</option>
        </select>
        <input
          type="text"
          placeholder={`Search by ${filterField}`}
          value={searchTerm}
          onChange={handleSearchChange}
        />
      </div>
      {employees.length > 0 ? (
        <EmployeesTable employees={employees} filterField={filterField} searchTerm={searchTerm} />
      ) : (
        <p>Loading...</p>
      )}
    </div>
  )
}
