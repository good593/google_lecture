---
marp: true
---
# [MiniKube](https://minikube.sigs.k8s.io/docs/)
- [참고용](https://www.padok.fr/en/blog/minikube-kubeadm-kind-k3s)

Minimum requirements for the host machine:
- CPU: 2
- Memory: 2 GB
- Disk space: 20 GB

---
## MiniKube Architecture
![Alt text](./img/minikube/image-19.png)

---
## MiniKube 장단점
- The inconvenience of this solution is this is not possible to add other nodes

![Alt text](./img/minikube/image-18.png)

---
# [Hello Minikube](https://kubernetes.io/docs/tutorials/hello-minikube/)
## 1. Create a minikube cluster
```shell
minikube start
```

---
## 2. Open the Dashboard
```shell
minikube dashboard
```
![Alt text](./img/minikube/image.png)

---
- [요류 발생: Unable to resolve the current Docker CLI context "default": context "default": context not found: on Windows](https://stackoverflow.com/questions/77208746/unable-to-resolve-the-current-docker-cli-context-default-context-default-c)
```shell
# 해결방법 
docker context use default
```

---
## 3. Create a Deployment
- create a Deployment that manages a Pod.
```shell
# Run a test container image that includes a webserver
kubectl create deployment hello-node --image=registry.k8s.io/e2e-test-images/agnhost:2.39 -- /agnhost netexec --http-port=8080
```
![Alt text](./img/minikube/image-1.png)

- View the Deployment
```shell
kubectl get deployments
```
![Alt text](./img/minikube/image-2.png)

---
- View the Pod
```shell
kubectl get pods
```
![Alt text](./img/minikube/image-3.png)

- View cluster events
```shell
kubectl get events
```
![Alt text](./img/minikube/image-4.png)

---
- View the kubectl configuration
```shell
kubectl config view
```
![Alt text](./img/minikube/image-5.png)

- View application logs for a container in a pod
```shell
kubectl logs <pod name>
```
![Alt text](./img/minikube/image-6.png)

---
## 4. Create a Service
- Expose the Pod to the public internet
```shell
kubectl expose deployment hello-node --type=LoadBalancer --port=8080
```
![Alt text](./img/minikube/image-7.png)

- View the Service
```shell
kubectl get services
```
![Alt text](./img/minikube/image-8.png)

---
- Run the following command
    - This opens up a browser window that serves your app and shows the app's response.
```shell
minikube service hello-node
```
![Alt text](./img/minikube/image-9.png)

---
## 5. Enable addons
- List the currently supported addons
```shell
minikube addons list
```
![Alt text](./img/minikube/image-10.png)

---
- Enable an addon, for example
```shell
minikube addons enable metrics-server
```
![Alt text](./img/minikube/image-11.png)

---
- View the Pod and Service you created by installing that addon
```shell
kubectl get pod,svc -n kube-system
```
![Alt text](./img/minikube/image-12.png)

---
- Disable `metrics-server`
```shell
minikube addons disable metrics-server
```
![Alt text](./img/minikube/image-14.png)

---
## 6. Clean up 
```shell
kubectl delete service hello-node
```
![Alt text](./img/minikube/image-15.png)
```shell
kubectl delete deployment hello-node
```
![Alt text](./img/minikube/image-16.png)
```shell
minikube stop
```
![Alt text](./img/minikube/image-17.png)

