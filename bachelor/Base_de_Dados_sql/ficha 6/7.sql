SELECT DepId,DEPARTMENT.Name,Manager,STAFF.Name
From DEPARTMENT,STAFF
WHERE Manager=StaffId;
