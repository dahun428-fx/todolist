/**
 * 
 */
var app = new Vue({
	el:"#app",
	data:{
		employees:[],
		departments:[],
		jobs:[]
	},
	beforeCreate:function(){
		axios.get("/hr/employees")
		.then(function(response){
			app.employees = response.data;
		})
		axios.get("/hr/departments")
		.then(function(response){
			app.departments = response.data;
		})
		axois.get("/hr/jobs")
		.then(function(response){
			app.jobs = response.data;	
		})
		
	}
})