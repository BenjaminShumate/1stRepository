
var myData = [
    {"dealId" : 0, "client_name" : "Microsoft", "project_name" : "Apollo Project", "project_manager" : "Mary", "project_cost" : 1000},
    {"dealId" : 1, "client_name" : "Intel", "project_name" : "Hermes Project", "project_manager" : "Bob", "project_cost" : 10000},
    {"dealId" : 2, "client_name" : "Apple", "project_name" : "Zeus Project", "project_manager" : "Jane", "project_cost" : 100000}
]

var currentDealId = myData.length;

function CreateTableFromJSON() {    
    var col = [];
    for (var i = 0; i < myData.length; i++) {
        for (var key in myData[i]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }
    
    var table = document.createElement("table");
    var tr = table.insertRow(-1);                  
    
    for (var i = 0; i < col.length; i++) {
        var th = document.createElement("th");      
        th.innerHTML = col[i];
        tr.appendChild(th);
    }

    for (var i = 0; i < myData.length; i++) {
        tr = table.insertRow(-1);
        for (var j = 0; j < col.length; j++) {
            var tabCell = tr.insertCell(-1);
            tabCell.innerHTML = myData[i][col[j]];
        }
    }

    var divContainer = document.getElementById("showData");
    divContainer.innerHTML = "";
    divContainer.appendChild(table);
}

function AddNewDeal() {
    var clientName = document.getElementById("clientNameInput").value;
    var projectName = document.getElementById("projectNameInput").value;
    var projectManager = document.getElementById("projectManagerInput").value;

    document.getElementById("clientNameInput").value = "";
    document.getElementById("projectNameInput").value = "";
    document.getElementById("projectManagerInput").value = "";

    myData.push({"dealId": currentDealId, "client_name" : clientName, "project_name" : projectName, "project_manager" : projectManager, "project_cost" : 0})
    currentDealId++;
    CreateTableFromJSON(); 
}

function editDeal() {
    var dealId = document.getElementById("dealIdInput").value;
    var clientName = document.getElementById("clientNameInput").value;
    var projectName = document.getElementById("projectNameInput").value;
    var projectManager = document.getElementById("projectManagerInput").value;
    
    document.getElementById("dealIdInput").value = "";
    document.getElementById("clientNameInput").value = "";
    document.getElementById("projectNameInput").value = "";
    document.getElementById("projectManagerInput").value = "";
    
    myData.splice(dealId, 1, {"dealId" : dealId, "client_name" : clientName, "project_name" : projectName, "project_manager" : projectManager, "project_cost" : 0});
    CreateTableFromJSON();
}

function deleteDeal() {
    var dealId = document.getElementById("dealIdInput").value;
    document.getElementById("dealIdInput").value = "";
    myData.splice(dealId, 1);
    CreateTableFromJSON();
}

function editBudget() {
    var dealId = document.getElementById("dealIdInput").value;
    var projectCost = document.getElementById("projectCostInput").value;

    document.getElementById("dealIdInput").value = "";
    document.getElementById("projectCostInput").value = "";

    myData.splice(dealId, 1, {"dealId" : dealId, "client_name" : myData[dealId].client_name, "project_name" : myData[dealId].project_name, "project_manager" : myData[dealId].project_manager, "project_cost" : projectCost});
    CreateTableFromJSON();
}

