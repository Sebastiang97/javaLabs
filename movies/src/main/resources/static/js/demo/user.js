// Call the dataTables jQuery plugin
$(document).ready(function () {
  $('#users').DataTable();
  loadUsers()
  console.log('sad')
  $('#users tbody').append(`

  `)
});


const loadUsers = async () => {
  const res = await fetch('http://localhost:8080/users', {
    method: 'POST', // *GET, POST, PUT, DELETE, etc.
    headers: {
      'Content-Type': 'application/json'
    }
  })
  const data = await res.json()
  console.log(data)

}
