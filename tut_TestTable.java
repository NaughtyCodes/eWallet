package org.ewallet.model;

public class TestTable {

	private String name;
	private String age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "TestTable [name=" + name + ", age=" + age + "]";
	}
	
/*	@PostMapping(value = "/Post")
	public @ResponseBody List<TestTable> postCall1(@RequestBody List<TestTable> testTable) {
		System.out.println(testTable.toString());
		System.out.println(testTable.get(0).getName());
		return testTable;
		
	}
*/
	
}

//HTML CONTENT

<!DOCTYPE html>
<html ng-app="myApp">
    <head lang="en">
        <meta charset="utf-8">
        <title>Custom Plunker</title>  
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/ng-grid/2.0.11/ng-grid.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.2/angular.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/ng-grid/2.0.11/ng-grid.min.js"></script>
        
        <style>
			 /*style.css*/
			.gridStyle {
			    border: 1px solid rgb(212,212,212);
			    width: 400px; 
			    height: 300px
			}
       	</style>
    </head>
    <body ng-controller="MyCtrl">
    <a href="hellox.html">Click Here</a>
        <div class="gridStyle" ng-grid="gridOptions">
            <pre>{{gridOptions.selectedItems}}</pre>
            <input ng-click="postMsg('ITS WORKING')" type="button" value="submit"></input>
            <pre>{{showMsg}}</pre>
            <pre>-------------------------------------------</pre>
            <pre>{{response}}</pre>
        </div>
    </body>
    
    <script>
 // main.js
    var app = angular.module('myApp', ['ngGrid']);
    app.controller('MyCtrl', function($scope,$http) {
    	var sc = $scope;
    	var http = $http;
        $scope.myData = [{name: "Moroni", age: 50},
                         {name: "Tiancum", age: 43},
                         {name: "Jacob", age: 27},
                         {name: "Nephi", age: 29},
                         {name: "Enos", age: 34}];
        $scope.gridOptions = { 
          data: 'myData', selectedItems: [], 
          enableCellSelection: true,
          enableCellEditOnFocus: true,
          enableRowSelection: true,
          columnDefs: [{field: 'name', displayName: 'Name', enableCellEdit: true}, {field:'age', displayName:'Age'}]
        };
        
        $scope.postMsg = function(s){
            alert(s);
            sc.showMsg = sc.gridOptions.selectedItems;
            sc.response = http.post("http://localhost:8080/eDynamicWallet/Post", sc.gridOptions.selectedItems);
        }
    });
    </script>
</html><!DOCTYPE html>
<html ng-app="myApp">
    <head lang="en">
        <meta charset="utf-8">
        <title>Custom Plunker</title>  
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/ng-grid/2.0.11/ng-grid.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.2/angular.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/ng-grid/2.0.11/ng-grid.min.js"></script>
        
        <style>
			 /*style.css*/
			.gridStyle {
			    border: 1px solid rgb(212,212,212);
			    width: 400px; 
			    height: 300px
			}
       	</style>
    </head>
    <body ng-controller="MyCtrl">
    <a href="hellox.html">Click Here</a>
        <div class="gridStyle" ng-grid="gridOptions">
            <pre>{{gridOptions.selectedItems}}</pre>
            <input ng-click="postMsg('ITS WORKING')" type="button" value="submit"></input>
            <pre>{{showMsg}}</pre>
            <pre>-------------------------------------------</pre>
            <pre>{{response}}</pre>
        </div>
    </body>
    
    <script>
 // main.js
    var app = angular.module('myApp', ['ngGrid']);
    app.controller('MyCtrl', function($scope,$http) {
    	var sc = $scope;
    	var http = $http;
        $scope.myData = [{name: "Moroni", age: 50},
                         {name: "Tiancum", age: 43},
                         {name: "Jacob", age: 27},
                         {name: "Nephi", age: 29},
                         {name: "Enos", age: 34}];
        $scope.gridOptions = { 
          data: 'myData', selectedItems: [], 
          enableCellSelection: true,
          enableCellEditOnFocus: true,
          enableRowSelection: true,
          columnDefs: [{field: 'name', displayName: 'Name', enableCellEdit: true}, {field:'age', displayName:'Age'}]
        };
        
        $scope.postMsg = function(s){
            alert(s);
            sc.showMsg = sc.gridOptions.selectedItems;
            sc.response = http.post("http://localhost:8080/eDynamicWallet/Post", sc.gridOptions.selectedItems);
        }
    });
    </script>
</html>
