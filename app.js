 var data = [{
			"year":2016,
			"impl":"key1",
            "id": 1,
            "parentId": 1,
            "name": "Loc2 child"
          },{
			"year":2016,
			"impl":"key1",
            "id": 2,
            "parentId": 1,
            "name": "Loc2 child"
          },{
			"year":2016,
			"impl":"key2",
            "id": 3,
            "parentId": 2,
            "name": "Loc2 child"
          },{
			"year":2017,
			"impl":"key1",
            "id": 4,
            "parentId": 1,
            "name": "Loc2 child"
          },{
			"year":2017,
			"impl":"key1",
            "id": 5,
            "parentId": 1,
            "name": "Loc2 child"
          }]
  
  
  function formatData(){
		
		year = {};
		var implObj = {};
		var implArray = [];
		var fdata = [];
		year['children'] = [];
		implObj['children'] = [];
		
		var tYear = "";
		var tImpl = "";
		var implChange = false;
		init = true;
		angular.forEach(data, function(value, key){
		
					
			if(tYear === "" || tYear === value.year){
				//--------------------------------------------
				year[Object.keys(value)[0]] = value.year;
				tYear = value.year;
				if(tImpl === "" || tImpl === value.impl){
					if(implObj === undefined)
					{
					implObj = {};
					implObj['children'] = [];
					}
					implObj.impl = value.impl;
					implObj['children'].push(value);
					tImpl = value.impl;
					implChange = false;
				} else {
					implChange = true;
					year['children'].push(implObj);
					var implObj = {};
					implObj['children'] = [];
					implObj[Object.keys(value)[1]] = value.impl;
					implObj['children'].push(value);
					tImpl = value.impl;
				}
				//--------------------------------------------
			} else {
				if(!implChange){
					year['children'].push(implObj);
				} else {
					fdata.push(year);
				}
					fdata.push(year);
					year = {};
					year['children'] = [];
					tYear = value.year;
					
			//--------------------------------------------
				year[Object.keys(value)[0]] = value.year;
				tYear = value.year;
				if(tImpl === "" || tImpl === value.impl){
					implObj.impl = value.impl;
					implObj["children"].push(value);
					tImpl = value.impl;
					implChange = false;
				} else {
					implChange = true;
					year['children'].push(implObj);
					var implObj = {};
					implObj['children'] = [];
					implObj[Object.keys(value)[1]] = value.impl;
					implObj['children'].push(value);
					tImpl = value.impl;
				}
				//--------------------------------------------
				
			} 
			
			console.dir(fdata);
		});
		
  }

var app = angular.module('app', ['ngAnimate', 'ngTouch', 'ui.grid', 'ui.grid.treeView', 'ui.grid.pagination']);

app.controller('MainCtrl', ['$scope', '$http', '$interval', 'uiGridTreeViewConstants', function ($scope, $http, $interval, uiGridTreeViewConstants ) {
  
 
  
  formatData();
  
  
  $scope.gridOptions = {
    enableSorting: true,
    enableFiltering: true,
    showTreeExpandNoChildren: true,
    paginationPageSizes: [5, 10],
    paginationPageSize: 5,
    columnDefs: [
	{ name: 'year'},
	{ name: 'impl'},
      { name: 'id'},
      { name: 'parentId' },
      { name: 'name'},
     ]
  };

var data =[{
    "year": 2016,
    "children": [{
        "impl": "key1",
        "children": [{
			"year":2016,
			"impl":"key1",
            "id": 4,
            "parentId": 2,
            "name": "Loc2 child",
            "children": []
          },{
			"year":2016,
			"impl":"key1",
            "id": 4,
            "parentId": 2,
            "name": "Loc2 child",
            "children": []
          }]
      },{
        "impl": "key2",
        "children": [{
			"year":2016,
			"impl":"key2",
            "id": 4,
            "parentId": 2,
            "name": "Loc2 child",
            "children": []
          }]
      }]
  },{
    "year": 2017,
    "children": [{
        "impl": "key1",
        "children": [{
			"year":2017,
			"impl":"key1",
            "id": 4,
            "parentId": 2,
            "name": "Loc2 child",
            "children": []
          },{
			"year":2017,
			"impl":"key1",
            "id": 4,
            "parentId": 2,
            "name": "Loc2 child",
            "children": []
          }]
      
      }]
  }]

var writeoutNode = function( childArray, currentLevel, dataArray ){
  childArray.forEach( function( childNode ){
    if ( childNode.children.length > 0 ){
      childNode.$$treeLevel = currentLevel;
    }
    dataArray.push( childNode );
    writeoutNode( childNode.children, currentLevel + 1, dataArray );
  });
};

$scope.gridOptions.data = [];
writeoutNode( data, 0, $scope.gridOptions.data );
}]);
