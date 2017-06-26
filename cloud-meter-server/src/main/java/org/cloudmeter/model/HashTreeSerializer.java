package org.cloudmeter.model;

import java.io.IOException;
import java.util.LinkedList;

import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jorphan.collections.HashTree;
import org.apache.jorphan.collections.HashTreeTraverser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class HashTreeSerializer extends JsonSerializer<HashTree>  {
	
	private static final Logger log = LoggerFactory.getLogger(HashTreeSerializer.class);

	@Override
	public void serialize(HashTree tree, JsonGenerator generator, SerializerProvider serializer)
			throws IOException, JsonProcessingException {
		
		log.debug("serializing a hash tree.");
		
		
		generator.writeStartObject();
		tree.traverse(new JSonTraverser(generator));
		generator.writeEndObject();
		
	}
	
	class JSonTraverser implements HashTreeTraverser {

		private JsonGenerator jsonGen;
//		 private final LinkedList<TestElement> stack = new LinkedList<>();
		
		JSonTraverser(JsonGenerator arg1){
			this.jsonGen = arg1;
		}
		
		@Override
		public void addNode(Object node, HashTree subTree) {
			log.debug("Adding node {} to tree.", node.getClass().getSimpleName());			
				
			try {
				jsonGen.writeFieldName("hashTree");
				jsonGen.writeStartObject();
				
				jsonGen.writeFieldName(node.getClass().getName());
				jsonGen.writeObject(node);
				
			} catch (IOException e) {
				
				log.error("Cannot add node {}. Exception type: {}, message {}.",
						node.getClass().getSimpleName(), e.getClass().getName(), e.getMessage());
				if(node instanceof ThreadGroup){
					log.error("Can't make testplan", e);
				}
			}
				

		}

		@Override
		public void subtractNode() {
			log.debug("Subtracting node");
//			this.stack.pop();
			try {
				this.jsonGen.writeEndObject();
			} catch (IOException e) {
				log.error("Cannot finish node. Exception type: {}, message {},", 
						e.getClass().getName(), e.getMessage());
			}
		}

		@Override
		public void processPath() {
			log.debug("processing path. ");
//			try {
//				this.jsonGen.writeEndObject();
//			} catch (IOException e) {
//				log.error("Cannot finish hashtree. Exception type: {}, message {},", 
//						e.getClass().getName(), e.getMessage());
//			}
		}
		
	}


}
