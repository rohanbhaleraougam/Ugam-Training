function functionapi()

						{
                                var test = "Hello";
                            test = document.getElementById("demo").innerHTML;
                            const obj = JSON.parse(test);
                            document.getElementById("demo1").innerHTML = obj.data.first_name;
                            document.getElementById("demo2").innerHTML = obj.data.last_name;
                            document.getElementById("demo3").innerHTML = obj.data.email;
                            document.getElementById("demo4").innerHTML = obj.data.id;
                            document.getElementById("demo5").src = obj.data.avatar;
                       }