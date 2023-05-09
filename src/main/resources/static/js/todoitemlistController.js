//development APIs
const addAPI= 'http://localhost:8080/todoitemlist/add';
const displayAPI = 'http://localhost:8080/todoitemlist/all';
let todolistController = [];

function displayTodolist()
{
  //fetch data from database using the REST API endpoint from Spring Boot
  fetch(displayAPI)
    .then((resp) => resp.json())
    .then(function(data) {
    console.log("2. receive data")
    console.log(data);

    data.forEach(function (todoitemlist/*,index*/){
     const todolistObj = {
        id: todoitemlist.id,
        title: todoitemlist.title,
        description: todoitemlist.description,
        targetdate: todoitemlist.targetdate
        };

          todolistController.push(todolistObj);
             });

             renderTodolistPage();
           })
           .catch(function(error) {
               console.log(error);
           });
}


function renderTodolistPage(){
    let display = ` <thead>
                          <tr>
                              <th>Title</th>
                              <th>Description</th>
                              <th>Target Date</th>
                          </tr>
                     </thead>
                        <tbody>`;

    for(let i = 0; i < todolistController.length; i++){

        display += `<tr>
                        <td>${todolistController[i].title}</td>
                        <td>${todolistController[i].description}</td>
                        <td>${todolistController[i].targetdate}</td>
                     </tr>
                         </tbody>`

    }
    document.querySelector("#row").innerHTML= display;
}


function addTodoList(title, description, targetdate)
{


    //FormData is an Object provided by the Browser API for us to send the data over to the backend
   const formData = new FormData();
   formData.append('title', title);
   formData.append('description', description);
   formData.append('targetdate', targetdate);

  fetch(addAPI, {
        method: 'POST',
        body: formData
        })
        .then(function(response) {
            console.log(response.status); // Will show you the status
            if (response.ok) {
                alert("Successfully Added Todo-List Item!")
            }
            else {
               alert("Something went wrong. Please try again")
            }
        })
        .catch((error) => {
            console.error('Error:', error);
            alert("Error adding Todo-List Item")
        });
}