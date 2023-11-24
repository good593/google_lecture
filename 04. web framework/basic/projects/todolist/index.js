var app = angular.module("myApp", []);
app.controller("myController", function($scope) {
$scope.tasks = [];
// $scope.saved = localStorage.getItem("tasks");
// $scope.tasks =
//   localStorage.getItem("tasks") !== null
//     ? JSON.parse($scope.saved)
//     : [
//         { task_name: "Learn AngularJS", status: false },
//         { task_name: "Build an Angular app", status: false }
//       ];
// localStorage.setItem("tasks", JSON.stringify($scope.tasks));
$scope.saveTask = function() {
    $scope.tasks.push({ task_name: $scope.yourTask, status: false });
    //   localStorage.setItem("tasks", JSON.stringify($scope.tasks));
};
$scope.getTask = function() {
    var oldTasks = $scope.tasks;
    $scope.tasks = [];
    angular.forEach(oldTasks, function(task) {
    if (!task.done) $scope.tasks.push(task);
    });
    localStorage.setItem("tasks", JSON.stringify($scope.tasks));
};
$scope.delete = function(i) {
    $scope.tasks.splice(i, 1);
};
$scope.finished = function(i) {
    $scope.tasks[i].status = true;
};
});