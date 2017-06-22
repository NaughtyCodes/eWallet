var app = angular.module('app', [ 'ngAnimate', 'ngTouch', 'ui.grid',
		'ui.grid.treeView', 'ui.grid.pagination' ]);

app.controller('MainCtrl', [
		'$scope',
		'$http',
		'$interval',
		'uiGridTreeViewConstants',
		function($scope, $http, $interval, uiGridTreeViewConstants) {
			$scope.gridOptions = {
				enableSorting : true,
				enableFiltering : true,
				showTreeExpandNoChildren : true,
				paginationPageSizes : [ 5, 10 ],
				paginationPageSize : 5,
				columnDefs : [ {
					name : 'id',
					width : '30%'
				}, {
					name : 'parentId',
					width : '20%'
				}, {
					name : 'name',
					width : '20%'
				}, ]
			};

			//----------------------------------------------------------------------------------------------------
			
				var d = [
				         {"name":"name1","type":"type1","age":"1","city":"city1","address":"address2"},
				         {"name":"name1","type":"type2","age":"1","city":"city1","address":"address2"},
				         {"name":"name1","type":"type3","age":"1","city":"city1","address":"address2"},
				         {"name":"name1","type":"type1","age":"1","city":"city1","address":"address2"},
				         {"name":"name2","type":"type2","age":"2","city":"city2","address":"address2"},
				         {"name":"name2","type":"type2","age":"2","city":"city2","address":"address2"},
				         {"name":"name2","type":"type2","age":"2","city":"city2","address":"address2"},
				         {"name":"name2","type":"type1","age":"2","city":"city2","address":"address2"},
				         {"name":"name3","type":"type1","age":"3","city":"city3","address":"address2"},
				         {"name":"name3","type":"type3","age":"3","city":"city3","address":"address2"},
				         {"name":"name3","type":"type3","age":"3","city":"city3","address":"address2"}
				        ]
				
				//user input
				var ui = {
							"$$treeLevel_0":["name"],
							"$$treeLevel_1":["type"],
							"$$treeLevel_2":["age","city","address"]
						 }
				
				function readUserInput(ui,d){
					
					var to = {};
					var fd = [];
					
					for (var key in ui) {
						  if (ui.hasOwnProperty(key)) {
						    console.log(key + " -> " + ui[key]);
						    
						    angular.forEach(ui["$$treeLevel_0"], function(v, i){
						    	var tv = "";
						    	angular.forEach(d, function(dv, di){
						    		if(tv !== dv[v]){
						    			
						    			if(d.length === 0){
						    				to = {};
							    			to.children = [];
							    			to[v] = dv[v];
							    			to.$$treeLevel = key.split("_")[1];
						    			} else {
						    				fd.push(to);
							    			to = {};
							    			to.children = [];
							    			to[v] = dv[v];
							    			to.$$treeLevel = key.split("_")[1];
						    			}
						    			
						    		} else {
						    			to.children.push(dv);
						    		}
						    		
						    		if(d.length === di)
						    			fd.push(to);
								   
						    	});
						    	
						    });
						    
						 }
					}
				}
				
				
				var writeoutNode = function(childArray, currentLevel, dataArray) {
					childArray.forEach(function(childNode) {
						//    if ( childNode.children.length > 0 ){
						childNode.$$treeLevel = currentLevel;
						//    }
						dataArray.push(childNode);
						writeoutNode(childNode.children, currentLevel + 1,
								dataArray);
					});
				};

			//----------------------------------------------------------------------------------------------------

			$scope.gridOptions.data = [
			  {
				"id" : 1,
				"parentId" : 1,
				"name" : "TopLoc1",
				"$$treeLevel" : 0,
				"children" : [ {
					"id" : 2,
					"parentId" : 1,
					"name" : "Loc1 child",
					"$$treeLevel" : 1,
					"children" : [ {
						"id" : 4,
						"parentId" : 2,
						"name" : "Loc2 child",
						"$$treeLevel" : 2
					} ]
					
				}, {
					"id" : 3,
					"parentId" : 1,
					"name" : "Loc1 child",
					"$$treeLevel" : 1
				} ]
			
			}, {
				"id" : 2,
				"parentId" : 1,
				"name" : "Loc1 child",
				"children" : [ {
					"id" : 4,
					"parentId" : 2,
					"name" : "Loc2 child",
					"$$treeLevel" : 2
				} ],
				"$$treeLevel" : 1
			}, {
				"id" : 4,
				"parentId" : 2,
				"name" : "Loc2 child",
				"$$treeLevel" : 2
			}, {
				"id" : 3,
				"parentId" : 1,
				"name" : "Loc1 child",
				"$$treeLevel" : 1
			}]
			
''		} ]);
