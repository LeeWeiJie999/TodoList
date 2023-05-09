newForm.addEventListener('submit', (event) => {

   // Prevent default action of the Form submission
   event.preventDefault();
   const title = document.querySelector('#title').value;
    const description = document.querySelector('#description').value;
    const targetdate = document.querySelector('#targetdate').value;

    const date = new Date(targetdate);


    let day = date.getDate();
    if(day < 10){
        day = '0' + date.getDate();
    }
    let month = date.getMonth();
    if(month < 10){
        month = '0' + (date.getMonth() + 1);
    }
    const year = date.getFullYear();

    const newTargetDate = `${day}/${month}/${year}`;



   /*Step 2
       Do the Validation code here
   */

   //Step 3 calls a function from the customerController.js to access the API to add items to the database
   addTodoList(title, description, newTargetDate); //arguments

});