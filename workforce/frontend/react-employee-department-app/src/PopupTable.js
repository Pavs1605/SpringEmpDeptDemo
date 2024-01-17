import React, { useState } from 'react';

const PopupTable = ({ isOpen, onClose, tableData, empId }) => {
  const handleClose = () => {
    onClose();
  };

  return (
    <div>
      {isOpen && (
        <div className="popup">
        <table className="dept-table">
      <thead>
        <tr>
          <th>Department Id</th>
          <th>Department Name</th>
          <th>Department Location</th>
          <th>Actions</th>
        </tr>
      </thead>

      <tbody>
        {this.tableData.map((dept) => (
          <tr key={dept.departmentId}>
            <td>{dept.departmentId}</td>
            <td>{dept.departmentName}</td>
            <td>{dept.departmentLocation}</td>
            <td>  {<button className='show' onClick={() => this.addEmpToDept(dept.departmentId, emp.employeeId)}>Add emp to dept</button>}
     </td>
          </tr>
        ))}
      </tbody>
    </table>

          <button onClick={handleClose}>Close Popup</button>
        </div>
      )}
    </div>
  );
};

export default PopupTable;