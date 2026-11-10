#### Install kind
`scoop bucket add main`
`scoop innstall main/kind`

#### Create cluster from kind config file
`kind create cluster --name practice --config kind-config.yaml`

#### Check created cluters
`kubectl get nodes -o wide`
`kubectl config current-context`
`kubectl config get-contexts`
`kubectl config use-context [context]` `//to switch context` 

#### Run springboot app locally and build
`./mvnw spring-boot:run`
`./mvnw clean package`

#### Build docker image for app and run a container to test
`docker build -t hello-k8s:1.0 .`
`docker run --rm -p 8080:8080 hello-k8s:1.0`

#### Load the image into the kind cluster
`kind load docker-image hello-k8s:1.0  --name practice`
`docker exec practice-worker crictl images | grep hello`

#### Apply the k8s yaml files
`kubectl apply -f k8s/` 
`kubectl get deployments`
`kubectl get svc`
`kubectl get pods -o wide`

#### Test the deployment with port-forward
`kubectl port-forward svc/hello-k8s 8081:80`


#### Turn it into Helm chart
`helm create hello-chart`
`rm -rf hello-chart/templates/*`
`cp k8s/* hello-chart/templates/`
 - Update the template yamls with respective .Values from values.yaml and run `helm template hello hello-chart` to check the chart
 `kubectl delete -f k8s/` #ensure previous deployments are down
 `helm install hello hello-chart` # hello is the release name, hello-chart is chart folder
 `helm list`

#### Helm payoff, upgrade without touching any files
`helm upgrade hello hello-chart --set replicaCount=3`
`helm list`
`kubectl get pods`
`helm history hello`

### Helm rollback
`helm rollback hello 1`
`kubectl get pods`


### After making changes to the app
`./mvnw clean package`
`docker build -t hello-k8s:1.1 .`
`kind load docker-image hello-k8s:1.1 --name practice`
`helm upgrade hello hello-chart --set image.tag=1.1`
`kubectl port-forward svc/hello 8081:80`
If you wish to restart pods for changes `kubectl rollout restart deployment hello`