# Necesita el paramentro String "startIndex"

node {
    ['droolsjbpm-build-bootstrap','uberfire','guvnor','kie-wb-common','drools-wb','jbpm-wb'].eachWithIndex { project,index ->
        
        stage(project) { 
            echo "${params.startIndex.toInteger()} - ${index}"
            if(params.startIndex.toInteger()> index){
                echo "Skipping"
            }else{
                build(job:project, parameters: [[$class: 'BooleanParameterValue', name: 'TEST', value: true ]])
            }
        
       }
        
    
    }
}

