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
		}
		
	}
	
})