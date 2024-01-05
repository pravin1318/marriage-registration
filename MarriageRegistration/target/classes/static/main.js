 var myApp = angular.module("mymodule", []);
 /*   myApp.config(function ($routeProvider) {
        $routeProvider 
          
            .when("/review", {
                templateUrl: "reviewPage.html",
               
            })

           
            .otherwise({
                redirectTo: "/review"
            })


    })*/

		var mycontroller = function ($scope, $http,personService) {
			  $scope.formData = {}; // Initialize an empty person object
    $scope.reviewedPerson = null; // To store the reviewed person data
$scope.idd=null;






$scope.convertToCamelCase = function (input) {
       
  

    if (typeof input !== "string") {
      return input;
    }

  /*  return input
     .replace(/([A-Z])/g, (match) => ` ${match}`)
     .replace(/^./, (match) => match.toUpperCase());
*/
    return input
            .toLowerCase()
            .replace(/\b\w/g, function(match) {
               return match.toUpperCase();
            });

      };














    $scope.savePerson = function() {
        personService.savePerson($scope.formData)
            .then(function(response) {
                $scope.reviewedPersonId = response.data.id;
                $scope.idd=response.data.id;
                $scope.reviewPerson();
            })
            .catch(function(error) {
                console.error('Error saving person: ', error);
            });
    };

    $scope.reviewPerson = function() {
        personService.getPersonById($scope.reviewedPersonId)
            .then(function(response) {
                $scope.reviewedPerson = response.data;
            })
            .catch(function(error) {
                console.error('Error fetching reviewed person: ', error);
            });
    };
$scope.check=function(){
	console.log($scope.formData.image);
	if($scope.formData.block && $scope.formData.village){
		
	}else if($scope.formData.city && $scope.formData.locality){
		
	}else if($scope.formData.image){
		
	}
	else{
		swal({title: 'Error!',
					text: 'Please Fill required fields',
					type:'error'
					
				})
	}
}			
/*			$scope.updatePerson = function() {
    personService.updatePerson($scope.reviewedPersonId, $scope.updatedPerson)
        .then(function(response) {
            console.log('Person updated successfully:', response.data);
            $scope.reviewPerson();
        })
        .catch(function(error) {
            console.error('Error updating person: ', error);
        });
};*/
// Inside your AngularJS controller
$scope.openUpdateModal = function() {
    // Copy the current person details to the updatedPerson object
    angular.copy($scope.reviewedPerson, $scope.updatedPerson);

    // Open the Bootstrap modal
    $('#updatePersonModal').modal('show');
};

$scope.closeUpdateModal = function() {
    // Reset the updatedPerson object
    $scope.updatedPerson = {};

    // Close the Bootstrap modal
    $('#updatePersonModal').modal('hide');
};

$scope.updatePerson = function() {
    personService.updatePerson($scope.reviewedPersonId, $scope.formData)
        .then(function(response) {
            console.log('Person updated successfully:', response.data);

            // Close the modal after successful update
            $scope.closeUpdateModal();

            // Refresh the reviewed person details
            $scope.reviewPerson();
        })
        .catch(function(error) {
            console.error('Error updating person: ', error);
        });
};

			
			
			
			
			
			
			
			
			
			
			
			
			//old
			$http.get('/api') // Update the endpoint based on your backend API
				.then(function (response) {
					$scope.users = response.data;
				})
				.catch(function (error) {
					console.error('Error fetching data:', error);
				});

			$scope.searchText = " ";
			$scope.customFilter = function (user) {
				var searchText = $scope.searchText.toLowerCase();

				// Check if the search text is present in any column
				return Object.values(user).some(function (value) {
					return String(value).toLowerCase().includes(searchText);
				});
			};
			// $scope.show=true;
			$scope.toggleContent453 = function () {
				//   $scope.show =false;
			};
			$scope.show = true;


			$scope.formData = {}; // Object to store form data
			$scope.showReviewModal = false;
			$scope.fullpage = true;

			$scope.toggletable = function () {
				$scope.fullpage = false;


			}
			$scope.toggletable2 = function () {
				$scope.fullpage = true;


			}
			$scope.imageFile = null; // Initialize the imageFile variable

    $scope.selectImage = function() {
        // Trigger click event on the file input
        document.getElementById('image23').click();
    };

    // Optionally, you can handle the file selection change event
    document.getElementById('image23').addEventListener('change', function() {
        $scope.$apply(function() {
            $scope.imageFile = this.files[0];
            console.log('Image selected:', $scope.imageFile);
        });
    });
			      $scope.updateImagePreview = function (input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $scope.$apply(function () {
                            $scope.imagePreview = e.target.result;
                            $scope.o=true;
                          
                        });
                    };
                    reader.readAsDataURL(input.files[0]);
                }
            };
                $scope.getCurrentDate=function() {
            var currentDate = new Date();
            var year = currentDate.getFullYear();
            var month = (currentDate.getMonth() + 1).toString().padStart(2, '0');
            var day = currentDate.getDate().toString().padStart(2, '0');
            return `${year}-${month}-${day}`;
        }


			$scope.submitForm = function () {
if($scope.formData.firstname && $scope.formData.dob && $scope.formData.mobileno && $scope.formData.email && $scope.formData.marritalstatus && $scope.formData.area && $scope.o &&  $scope.formData.gender  && $scope.formData.age>=21 ){
	
$scope.formData.firstname=$scope.convertToCamelCase($scope.formData.firstname);

	
	
	
	
	
	
	
	
	if($scope.formData.area==='Rural'){if($scope.formData.block && $scope.formData.village && $scope.formData.district){
		
		$scope.formData.village=$scope.convertToCamelCase($scope.formData.village);
				swal({
						title: 'Success!',
					text: 'Your Form is Saved Successfully!',
				
					type: 'success'

					
				})
				if($scope.idd != null){
					$scope.updatePerson();
				}
				else{
				$scope.savePerson();}
				$scope.show = false;

				// Show the review modal
				$scope.showReviewModal = true;}
					else{
							
				swal({title: 'Error!',
					text: 'Please Fill District , Block and Village.',
					type:'error'
					
				})
			}
			 }
	 if($scope.formData.area==='Urban'){
		 if($scope.formData.city && $scope.formData.locality && $scope.formData.district){
			 $scope.formData.locality=$scope.convertToCamelCase($scope.formData.locality);
			 
					swal({
						title: 'Success!',
					text: 'Your Form is Saved Successfully!',
				
					type: 'success'

					
				})
				if($scope.idd != null){
					$scope.updatePerson();
				}
				else{
				$scope.savePerson();}
				$scope.show = false;

				// Show the review modal
				$scope.showReviewModal = true;
					
				}
					else{
				swal({title: 'Error!',
					text: 'Please Fill District, City and Locality',
					type:'error'
					
				})
			}
				
	}
		
			
				
				
				
				}	
				else if(!$scope.formData.firstname){
			swal({title: 'Error!',
					text: 'Please Fill Name',
					type:'error'
					
				})
		}
		else if(!$scope.formData.email){
			swal({title: 'Error!',
					text: 'Please Fill Email',
					type:'error'
					
				})
		}
		
		else if(!$scope.formData.dob){
			swal({title: 'Error!',
					text: 'Please Select Date Of Birth',
					type:'error'
					
				})
		}
		else if(!$scope.formData.mobileno){
			swal({title: 'Error!',
					text: 'Please Fill Mobile No.',
					type:'error'
					
				})
		}
			else if(!$scope.formData.marritalstatus){
			swal({title: 'Error!',
					text: 'Please Select Marital Status',
					type:'error'
					
				})
		}
		else if(!$scope.o){
			swal({title: 'Error!',
					text: 'Please Upload Photo',
					type:'error'
					
				})
		}
		
		
		else if(!$scope.formData.gender){
			swal({title: 'Error!',
					text: 'Please Select Gender',
					type:'error'
					
				})
		}
	
		else if(!$scope.formData.area){
			swal({title: 'Error!',
					text: 'Please Select Area',
					type:'error'
					
				})
		}
			else{
				swal({title: 'Error!',
					text: 'Please Fill required fields',
					type:'error'
					
				})
			}
			};

			$scope.closeReview = function () {
				// Close the review modal
				$scope.showReviewModal = false;
				$scope.show = true;


			};

			$scope.confirmSubmit = function () {
				swal({
					title: 'Success!',
					text: 'Form submitted successfully!',
					type: 'success'
				});
				// Perform any final submission logic if needed
				// For this example, let's simulate a successful submission
				console.log('Form submitted successfully', $scope.formData);
			
					//$scope.updatePerson();
	$http.post('/savedetail', $scope.formData)
					.then(function (response) {
						console.log('Server response:', response.data);
					})
					.catch(function (error) {
						console.error('Error:', error);
					});

				$scope.show = true;
				$scope.formData = null;
				// Close the review modal
				$scope.showReviewModal = false;
			};
			$scope.res = {};
			$scope.button = false;
			$scope.changeb = function () {
				$scope.button = true;

			}
	/*		$scope.uploadedImage = null;
			document.getElementById('image').addEventListener('change', function (event) {
				uploadedImage = document.getElementById('uploadedImage');
				uploadedImage.src = URL.createObjectURL(event.target.files[0]);
			});
			$scope.uploadedImage2 = null;
			document.getElementById('image').addEventListener('change', function (event) {
				uploadedImage2 = document.getElementById('uploadedImage2');
				uploadedImage2.src = URL.createObjectURL(event.target.files[0]);
			});*/
			$scope.photo = false;
			var img = {
				photo: "/images/pic.png"
			};
			var tech = [
				{name: "c#", likes: 0, dislikes: 0}
			];
			$scope.tech = tech;
			$scope.inlike = function (techno) {
				techno.likes++;
			};
			$scope.indlike = function (techno) {
				techno.dislikes++;
			};
			$scope.img = img;
			$scope.message = "angularjs tutorial";
			$scope.showExtraFieldurban = false;
			$scope.showExtraFieldrural = false;

			$scope.showContent = false;

			$scope.toggleContent2 = function () {
				$scope.showExtraFieldrural = false;
				$scope.showExtraFieldurban = true;
				$scope.formData.district=null;
				$scope.formData.block=null;
				$scope.formData.village=null;
			};
			$scope.toggleContent = function () {
				$scope.showExtraFieldurban = false;
				$scope.showExtraFieldrural = true;
				$scope.formData.district=null;
				$scope.formData.city=null;
				$scope.formData.locality=null;
			};

			$scope.showimg = function () {
				$scope.imgg = true;
			}

			$scope.popup = function () {
				$scope.imgg = true;
			}






			$scope.calculateAge = function () {
				
				// Calculate age logic here
				var today = new Date();
				var birthDate = new Date($scope.formData.dob);
				var age = today.getFullYear() - birthDate.getFullYear();

				// Check if birthday has occurred this year
				if (today.getMonth() < birthDate.getMonth() || (today.getMonth() === birthDate.getMonth() && today.getDate() < birthDate.getDate())) {
					age--;
				}

				$scope.formData.age = age;
				if (age < 21) {
          // User is underage
          $scope.isUnderage = true;
        } else {
          // User is 18 or older, proceed with your logic
          $scope.isUnderage = false;
      
          // Add your additional logic here
        }
			};

			$scope.districts = districts;
			$scope.selectedDistrict = null;
			$scope.selectedBlock = null;
			$scope.selectedVillage = null;


			$scope.blockDisabled = true;
			$scope.villageDisabled = true;

			$scope.selectDistrict = function () {
				$scope.blockDisabled = false;
				$scope.selectedBlock = null;
				$scope.selectedVillage = null;
			};


			$scope.selectBlock = function () {
				$scope.villageDisabled = false;
				$scope.selectedVillage = null;
			};
			$scope.urbanDistricts = ['Indore', 'Bhopal', 'Ujjain', 'Rewa', 'Jabalpur'];
	$scope.urbanCities = {
		'Indore': ['Rau', 'Indore','Sanwer', 'Malharganj', 'Mhow','Depalpur'],
		'Ujjain': ['Mahidpur','Ujjain', 'Nagda', 'Badnagar', 'Tarana'],
		'Rewa': ['Rewa', 'Raipur Karchuliyan', 'Gangev', 'Teonthar'],
		'Jabalpur': ['Jabalpur', 'Kundam', 'Majhouli', 'Sihora','Shahpura'],
		'Bhopal': ['Bhopal','Berasiya', 'Phanda', 'Huzur']
	};

	$scope.ruralDistricts = ['Raisen', 'Rajgarh', 'Sehore', 'Vidisha','Chhindwara'];
	$scope.ruralBlocks = {
		'Raisen': ['Begumganj', 'Gairatganj', 'Bareli','Goharganj','Silwani'],
		'Rajgarh': ['Khilchipur', 'Biaora', 'Narsinghgarh','Sarangpur'],
		'Sehore': ['Bhainsdehi', 'Betul', 'Amla'],
		'Vidisha':['Basoda','Kurwai','Sironj','Nateran','Gyaraspur'],
		'Chhindwara': ['Parasia', 'Chhindawara', 'Sausar','Pandhurna','Chourai']
	};
		};
		myApp.controller("mycontroller", mycontroller);
		var districts = [
			{
				name: 'District 1',
				blocks: [
					{name: 'Block 1.1', villages: ['Village 1.1.1', 'Village 1.1.2']},
					{name: 'Block 1.2', villages: ['Village 1.2.1', 'Village 1.2.2']}
				]
			},
			{
				name: 'District 2',
				blocks: [
					{name: 'Block 2.1', villages: ['Village 2.1.1', 'Village 2.1.2']},
					{name: 'Block 2.2', villages: ['Village 2.2.1', 'Village 2.2.2']}
				]
			}
		];
		myApp.service('personService', function($http) {
    this.savePerson = function(formData) {
        return $http.post('/api/persons', formData);
    };

    this.getPersonById = function(id) {
        return $http.get('/api/persons/' + id);
    };
    
this.updatePerson = function(id, updatedPerson) {
    return $http.put('/api/persons/' + id, updatedPerson);
};
});