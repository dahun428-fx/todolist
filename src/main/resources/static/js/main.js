var app = new Vue({
	el:"#app",
	data:{
		isShowForm: false,
		departments: [],
		jobs: [],
		managers: [],
		employees: [],
		emp:{}
	},
	beforeCreate:function(){
		axios.get("/hr/employees")
		.then(function(response){
			app.employees = response.data;
		});
		axios.get("/hr/departments")
		.then(function(response){
			app.departments = response.data;
		});
		axios.get("/hr/managers")
		.then(function(response){
			app.managers = response.data;
		});
		axios.get("/hr/jobs")
		.then(function(response){
			app.jobs = response.data;
		});
		
	},
	methods:{
	
		showEmployeeDetail:function(employee){
			app.emp = employee;
			console.log(app.emp);
			app.openForm();
		},
		openForm:function(){
			app.isShowForm = true;
		},
		closeForm:function(){
			app.isShowForm = false;
			app.clearForm();
		},
		clearForm:function(){
			app.emp = {};
		},
		toggleForm:function(){
			if(app.isShowForm){
				app.closeForm();
			} else {
				app.openForm();
			}
		},
		insertEmployee:function(emp){
			axios.post("/hr/employees", emp)
			.then(function(response){
				app.employees = response.data;
				app.closeForm();
			})
		},
		deleteEmployee:function(emp){
			axios.delete("/hr/employees/"+emp.id)
			.then(function(response){
				app.employees = response.data;
				app.closeForm();
			})
		},
		updateEmployee:function(emp){
			axios.put("/hr/employees/"+emp.id, emp)
			.then(function(response){
				app.employees = response.data;
				app.closeForm();
			})
		},
		confirmEmployee:function(emp){
			console.log("before", emp)
			console.log("before id", emp.id);
			if(emp.id == null){console.log('null')}
			if(emp.id == null){
				app.insertEmployee(emp);
			} else {
				app.updateEmployee(emp);
			}
		
		}
	}
	
})