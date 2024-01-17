import logo from './logo.svg';
import styles from './App.css';
import Popup from 'reactjs-popup';
import React, { Component } from 'react';


class App extends Component {

  constructor() {
    super();

    this.state = {
      departments: [],
      employees: [],
      employeesList: [],
      employeeRow: null,
      inputValue: '',
      showDepartments: false,
      showEmployees: false,
      showAllEmployees: false,
      editedEmployee: null,
      showEmployeeForm: false
    };
  };




  render() {
    return (
      <div>
        <header>
          <img src={logo} alt="logo" width="100em" height="100em" />
        </header>

        <h1>Departments</h1>
        <div className="dept-button-container">
          <div>
            <p> Click on get all departments button to get list of departments</p>
            <div style={{ marginTop: '10px' }}>   <button className="show" onClick={this.getAllDepartments}>Get All Departments</button> </div>
          </div>

          <div>
            <p> Click on get all employees button to get list of employees</p>
            <div style={{ marginTop: '10px' }}>   <button className="show" onClick={this.getAllEmployees}>Get All Employees</button> </div>
          </div>


          <div>
            <br></br>
            <div>
              <p> Provide department id to get employees per department</p>
              <input
                type="text"
                onChange={this.handleChange}
                id="deptId"
                placeholder="Enter Department ID"
              />
            </div>
            <br></br>
            <div>
              <button className="show" onClick={this.getAllEmployeesPerDepartment}>Get Employees</button>
            </div>
          </div>
        </div>

        {this.state.showDepartments && (this.state.departments) && (this.state.departments.length !== 0) &&
          this.renderDepartmentsTable()}

        {this.state.showAllEmployees && (this.state.showAllEmployees) && (this.state.employeesList.length !== 0) &&
          this.renderEmployeesTable()}


        {this.state.showEmployees && (this.state.employees) && (this.state.employees.length !== 0) && this.renderEmployeesTablePerDept()}


        {this.state.showEmployeeForm && (this.state.employeeRow) && (this.state.employeeRow !== null) && this.renderEmployeeForm()
        }


      </div>
    );
  };
  renderEmployeeForm() {
    return (

      <div style={{ maxWidth: '400px', marginTop: '10px' }}>
        <h2>Edit Employee</h2>
        <form>
          <div style={{ marginBottom: '15px' }}>
            <label>
              Employee ID
              <input type="text" name="empId" value={this.state.employeeRow.employeeId} readOnly style={{ marginLeft: '52px', marginBottom: '30px' }}
              />
            </label>
            <br />
            <label>
              Employee Name
              <input type="text" name="employeeName" value={this.state.employeeRow.employeeName || ''} style={{ marginLeft: '24px', marginBottom: '30px' }}
                onChange={this.handleChangeEmployee}
              />
            </label>
            <br />
            <label>
              Employee Position
              <input type="text" name="employeePosition" value={this.state.employeeRow.employeePosition} style={{ marginLeft: '10px', marginBottom: '30px' }}
                onChange={this.handleChangeEmployee} />
            </label>
            <br />
            <label>
              Employee Salary
              <input type="text" name="employeeSalary" value={this.state.employeeRow.employeeSalary} style={{ marginLeft: '22px', marginBottom: '30px' }}
                onChange={this.handleChangeEmployee} />
            </label>
            <div style={{ marginTop: '10px', marginRight: '15px' }}>
              <button type="button" onClick={this.handleSave}>
                Save
              </button>
              <button className="delete" onClick={this.handleDelete}>
                Delete
              </button>
            </div>
          </div>
        </form>

      </div>
    )
  }

  renderEmployeesTablePerDept() {
    return (
      <div>
        <table className="dept-table">
          <thead>
            <tr>
              <th> Employee Id </th>
              <th> Employee Name </th>
              <th> Employee Email </th>
              <th> Employee Position </th>
              <th> Employee Salary </th>
              <th>Department Name </th>
              <th> Actions </th>
            </tr>
          </thead>


          <tbody>
            {this.state.employees.map((emp) => (
              <tr key={emp.employeeId}>
                <td>
                  {emp.employeeId}
                </td>
                <td>
                  {emp.employeeName}
                </td>
                <td>
                  {emp.employeePosition}
                </td>
                <td>{emp.employeeEmailAddress}</td>
                <td>{emp.employeeSalary}</td>
                <td> {emp.departmentName} </td>


                <td><div style={{ marginLeft: '10px' }}>
                  <button className='show' onClick={() => this.fetchEmployee(emp.employeeId)}>Edit</button>
                  &nbsp;
                  <button className='show' onClick={() => this.handleDeleteFromDept(this.state.inputValue, emp.employeeId)}>Remove</button>
                </div></td>

              </tr>
            ))}
          </tbody>
        </table>
      </div>

    )
  }
  renderDepartmentsTable() {
    return (<table className="dept-table">
      <thead>
        <tr>
          <th>Department Id</th>
          <th>Department Name</th>
          <th>Department Location</th>
        </tr>
      </thead>

      <tbody>
        {this.state.departments.map((dept) => (
          <tr key={dept.departmentId}>
            <td>{dept.departmentId}</td>
            <td>{dept.departmentName}</td>
            <td>{dept.departmentLocation}</td>
          </tr>
        ))}
      </tbody>
    </table>

    )

  }
  renderEmployeesTable() {
    return (
      <div>
        <table className="dept-table">
          <thead>
            <tr>
              <th> Employee Id </th>
              <th> Employee Name </th>
              <th> Employee Email </th>
              <th> Employee Position </th>
              <th> Employee Salary </th>
              <th>Department Name </th>
              <th> Actions </th>
            </tr>
          </thead>


          <tbody>
            {this.state.employeesList.map((emp) => (
              <tr key={emp.employeeId}>
                <td>
                  {emp.employeeId}
                </td>
                <td>
                  {emp.employeeName}
                </td>
                <td>
                  {emp.employeePosition}
                </td>
                <td>{emp.employeeEmailAddress}</td>
                <td>{emp.employeeSalary}</td>
                <td>{emp.departmentName}</td>

                <td><div style={{ marginLeft: '10px' }}>
                  <button className='show' onClick={() => this.fetchEmployee(emp.employeeId)}>Edit</button>
                </div></td>

              </tr>
            ))}
          </tbody>
        </table>
      </div>

    )
  }

  renderDeptTable = () => {


  };
  handleChangeEmployee = (e) => {
    const { name, value } = e.target;
    this.setState((prevState) => ({
      employeeRow: {
        ...prevState.employeeRow,
        [name]: value,
      },
    }));
  };


  handleSave = () => {
    const editedEmployee = this.state.employeeRow;

    // Ensure editedEmployee is not null and has an employeeId
    if (editedEmployee && editedEmployee.employeeId) {
      const url = 'http://localhost:8080/employees/' + editedEmployee.employeeId;

      fetch(url, {
        method: 'PATCH',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(editedEmployee),
      })
        .then((response) => {
          if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
          }
          return response.json();
        })
        .then((updatedEmployee) => {
          console.log('Employee updated successfully:', updatedEmployee);

          // Reset editedEmployee to null after saving
          this.setState({ editedEmployee: null });
        })
        .catch((error) => {
          console.error('Error updating employee:', error);
        });
    } else {
      console.error('Invalid employee data');
    }

    // Reset editedEmployee to null after saving
    //    this.setState({ employeeRow: null });
  };

  handleDelete = () => {
    const editedEmployee = this.state.employeeRow;

    // Ensure editedEmployee is not null and has an employeeId
    if (editedEmployee && editedEmployee.employeeId) {
      const url = 'http://localhost:8080/employees/' + editedEmployee.employeeId;

      fetch(url, {
        method: 'DELETE'
      })
        .then((response) => {
          if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
          }
          return response.json();
        })
        .then((updatedEmployee) => {
          console.log('Employee deleted successfully:', updatedEmployee);

          // Reset editedEmployee to null after saving
          this.setState({ editedEmployee: null });
        })
        .catch((error) => {
          console.error('Error updating employee:', error);
        });
    } else {
      console.error('Invalid employee data');
    }

    // Reset editedEmployee to null after deleting
    this.setState({ employeeRow: null });
  };

  handleDeleteFromDept = (deptId, empId) => {
    const url = 'http://localhost:8080/departments/deleteEmployeeFromDepartment/' + deptId + '/' + empId;

    fetch(url, {
      method: 'DELETE'
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error(`HTTP error! Status: ${response.status}`);
        }
        this.getAllEmployeesPerDepartment();
        return response.json();
      })
      .then((updatedEmployee) => {
        console.log('Employee deleted successfully:', updatedEmployee);
        this.getAllEmployeesPerDepartment();


      })
      .catch((error) => {
        console.error('Error updating employee:', error);
      });
  }

  fetchEmployee = (empId) => {

    try {

      const url = 'http://localhost:8080'

      fetch(url + '/employees/' + empId)
        .then(response => response.json())
        .then(data => {

          this.setState({ employeeRow: data, showEmployees: false, showDepartments: false, showEmployeeForm: true, showAllEmployees: false });

        })
        .catch(error => {
          console.error('Error fetching departments:', error);
        });
    }
    catch (error) {
      console.error('Error fetching departments:', error);
    }

  };


  handleChange = (event) => {

    this.setState({ inputValue: event.target.value });
  };

  addEmpToDept = () => {
    const url = 'http://localhost:8080'
    fetch(url + '/departments')
      .then(response => response.json())
      .then(data => {
        this.setState({ departments: data, showDepartments: true, showEmployees: false, showEmployeeForm: false, showAllEmployees: false });
      })
      .catch(error => {
        console.error('Error fetching departments:', error);
      });

    return (
      <Popup trigger=
        {<button> Click to open popup </button>}
        position="right center">
        <div>GeeksforGeeks</div>
        <button>Click here</button>
      </Popup>
    )
  };

  getAllDepartments = () => {
    const url = 'http://localhost:8080'
    fetch(url + '/departments')
      .then(response => response.json())
      .then(data => {
        this.setState({ departments: data, showDepartments: true, showEmployees: false, showEmployeeForm: false, showAllEmployees: false });
      })
      .catch(error => {
        console.error('Error fetching departments:', error);
      });
  };

  getAllEmployees = () => {
    const url = 'http://localhost:8080'
    fetch(url + '/employees')
      .then(response => response.json())
      .then(data => {
        this.setState({ employeesList: data, showDepartments: false, showAllEmployees: true, showEmployees: false, showEmployeeForm: false });
      })
      .catch(error => {
        console.error('Error fetching departments:', error);
      });
  };


  getAllEmployeesPerDepartment = () => {
    let deptId = this.state.inputValue;
    const url = 'http://localhost:8080'
    fetch(url + '/departments/' + deptId + '/employees')
      .then(response => response.json())
      .then(data => {
        this.setState({ employees: data, showDepartments: false, showEmployees: true, showEmployeeForm: false, showAllEmployees: false });
      })
      .catch(error => {
        console.error('Error fetching departments:', error);
      });
  };

  fetchDepartments = () => {
    try {
      let deptId = this.state.inputValue;
      const url = 'http://localhost:8080'

      fetch(url + '/departments/' + deptId)
        .then(response => response.json())
        .then(data => {
          this.setState({ department: data, showDepartments: true, showEmployees: false, showEmployeeForm: false, showAllEmployees: false });
        })
        .catch(error => {
          console.error('Error fetching departments:', error);
        });
    }
    catch (error) {
      console.error('Error fetching departments:', error);
    }
  };

}

export default App;
