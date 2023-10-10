# imageupload
RESTapi with ability to upload images

# Response structure

Responses have similar structure:
<br>&emsp;  data: ~ 
<br>&emsp;  message: ~ 
<br>&emsp;  status: ~ 

# Requests:

GET: /orders/<br>
&emsp;Take no params<br>
&emsp;Returns list of all orders<br>
&emsp;Example:<br>
![alt text](https://github.com/KeillsIDP/imageupload/blob/main/img/get.png?raw=true)

POST: /orders/create<br>
&emsp;Take params:<br>
  &emsp;&emsp;file: multipart/form-data, required<br>
  &emsp;&emsp;order: application/json, required<br>
&emsp;Creates new order, and returns it<br>
&emsp;Example:<br>
![alt text](https://github.com/KeillsIDP/imageupload/blob/main/img/post.png?raw=true)

DELETE: /orders/delete/{id}<br>
&emsp;Takes PathParam - id (Long)<br>
&emsp;Returns general response form with data:""<br>
&emsp;Example:<br>
![alt text](https://github.com/KeillsIDP/imageupload/blob/main/img/delete.png?raw=true)
