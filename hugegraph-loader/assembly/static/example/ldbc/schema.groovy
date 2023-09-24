/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
// Define schema
// Comment
schema.propertyKey("creationDate").asLong().ifNotExist().create();
schema.propertyKey("id").asLong().ifNotExist().create();
schema.propertyKey("locationIP").asText().ifNotExist().create();
schema.propertyKey("browserUsed").asText().ifNotExist().create();
schema.propertyKey("content").asText().ifNotExist().create();
schema.propertyKey("length").asInt().ifNotExist().create();
//schema.propertyKey("CreatorPersonId").asLong().ifNotExist().create();
//schema.propertyKey("LocationCountryId").asLong().ifNotExist().create();
//schema.propertyKey("ParentPostId").asLong().ifNotExist().create();
//schema.propertyKey("ParentCommentId").asLong().ifNotExist().create();
// Forum
schema.propertyKey("title").asText().ifNotExist().create();
//schema.propertyKey("ModeratorPersonId").asLong().ifNotExist().create();
// Person
schema.propertyKey("firstName").asText().ifNotExist().create();
schema.propertyKey("lastName").asText().ifNotExist().create();
schema.propertyKey("gender").asText().ifNotExist().create();
schema.propertyKey("birthday").asLong().ifNotExist().create();
schema.propertyKey("language").asText().ifNotExist().create();
schema.propertyKey("LocationCityId").asLong().ifNotExist().create();
schema.propertyKey("email").asText().ifNotExist().create();
schema.propertyKey("classYear").asInt().ifNotExist().create();
schema.propertyKey("workFrom").asInt().ifNotExist().create();
// Post
schema.propertyKey("imageFile").asText().ifNotExist().create();
//schema.propertyKey("ContainerForumId").asLong().ifNotExist().create();
//Organisation
schema.propertyKey("type").asText().ifNotExist().create();
schema.propertyKey("name").asText().ifNotExist().create();
schema.propertyKey("url").asText().ifNotExist().create();
//Place
//schema.propertyKey("PartOfPlaceId").asInt().ifNotExist().create();
//Tag
//schema.propertyKey("TypeTagClassId").asInt().ifNotExist().create();
//TagClass
//schema.propertyKey("SubclassOfTagClassId").asInt().ifNotExist().create();
//edge_properties
schema.propertyKey("joinDate").asLong().ifNotExist().create();
schema.propertyKey("classYear").asInt().ifNotExist().create();
schema.propertyKey("workFrom").asInt().ifNotExist().create();



// vertex

schema.vertexLabel("Comment")
        .properties("id", "creationDate", "locationIP", "browserUsed", "content", "length")
        .nullableKeys("creationDate", "locationIP", "browserUsed", "content", "length")
        .primaryKeys("id")
        .ifNotExist()
        .create();

schema.vertexLabel("Forum")
        .properties("id", "title", "creationDate")
        .nullableKeys("title", "creationDate")
        .primaryKeys("id")
        .ifNotExist()
        .create();

schema.vertexLabel("Person")
        .properties("id", "firstName", "lastName", "gender", "birthday", "creationDate", "locationIP",
                "browserUsed", "language", "email")
        .nullableKeys("firstName", "lastName", "gender", "birthday", "creationDate", "locationIP",
                "browserUsed", "language", "email")
        .primaryKeys("id")
        .ifNotExist()
        .create();

schema.vertexLabel("Post")
        .properties("id", "imageFile", "creationDate", "locationIP", "browserUsed", "language", "content", "length")
        .nullableKeys("imageFile", "creationDate", "locationIP", "browserUsed", "language", "content", "length")
        .primaryKeys("id")
        .ifNotExist()
        .create();

schema.vertexLabel("Organisation")
        .properties("id", "type", "name", "url")
        .nullableKeys("type", "name", "url")
        .primaryKeys("id")
        .ifNotExist()
        .create();

schema.vertexLabel("Place")
        .properties("id", "name", "url", "type")
        .nullableKeys("name", "url", "type")
        .primaryKeys("id")
        .ifNotExist()
        .create();

schema.vertexLabel("Tag")
        .properties("id", "name", "url")
        .nullableKeys("name", "url")
        .primaryKeys("id")
        .ifNotExist()
        .create();

schema.vertexLabel("TagClass")
        .properties("id", "name", "url")
        .nullableKeys( "name", "url")
        .primaryKeys("id")
        .ifNotExist()
        .create();

// edge
schema.edgeLabel("Comment_hasCreator_Person")
        .sourceLabel("Comment")
        .targetLabel("Tag")
        .ifNotExist()
        .create();

schema.edgeLabel("Comment_hasTag_Tag")
        .sourceLabel("Comment")
        .targetLabel("Tag")
        .ifNotExist()
        .create();

schema.edgeLabel("Comment_isLocatedIn_Country")
        .sourceLabel("Comment")
        .targetLabel("Place")
        .ifNotExist()
        .create();

schema.edgeLabel("Comment_replyOf_Comment")
        .sourceLabel("Comment")
        .targetLabel("Comment")
        .ifNotExist()
        .create();

schema.edgeLabel("Comment_replyOf_Post")
        .sourceLabel("Comment")
        .targetLabel("Post")
        .ifNotExist()
        .create();

schema.edgeLabel("Forum_containerOf_Post")
        .sourceLabel("Forum")
        .targetLabel("Post")
        .ifNotExist()
        .create();

schema.edgeLabel("Forum_hasMember_Person")
        .sourceLabel("Forum")
        .targetLabel("Person")
        .properties("joinDate")
        .ifNotExist()
        .create();

schema.edgeLabel("Forum_hasModerator_Person")
        .sourceLabel("Forum")
        .targetLabel("Person")
        .ifNotExist()
        .create();

schema.edgeLabel("Forum_hasTag_Tag")
        .sourceLabel("Forum")
        .targetLabel("Tag")
        .ifNotExist()
        .create();

schema.edgeLabel("Person_hasInterest_Tag")
        .sourceLabel("Person")
        .targetLabel("Tag")
        .ifNotExist()
        .create();

schema.edgeLabel("Person_isLocatedIn_City")
        .sourceLabel("Person")
        .targetLabel("Place")
        .ifNotExist()
        .create();

schema.edgeLabel("Person_knows_Person")
        .sourceLabel("Person")
        .targetLabel("Person")
        .properties("creationDate")
        .ifNotExist()
        .create();

schema.edgeLabel("Person_likes_Comment")
        .sourceLabel("Person")
        .targetLabel("Comment")
        .properties("creationDate")
        .ifNotExist()
        .create();

schema.edgeLabel("Person_likes_Post")
        .sourceLabel("Person")
        .targetLabel("Post")
        .properties("creationDate")
        .ifNotExist()
        .create();


schema.edgeLabel("Person_studyAt_University")
        .sourceLabel("Person")
        .targetLabel("Organisation")
        .properties("classYear")
        .ifNotExist()
        .create();

schema.edgeLabel("Person_workAt_Company")
        .sourceLabel("Person")
        .targetLabel("Organisation")
        .properties("workFrom")
        .ifNotExist()
        .create();

schema.edgeLabel("Post_hasCreator_Person")
        .sourceLabel("Post")
        .targetLabel("Person")
        .ifNotExist()
        .create();

schema.edgeLabel("Post_hasTag_Tag")
        .sourceLabel("Post")
        .targetLabel("Tag")
        .ifNotExist()
        .create();

schema.edgeLabel("Post_isLocatedIn_Country")
        .sourceLabel("Post")
        .targetLabel("Place")
        .ifNotExist()
        .create();

schema.edgeLabel("Company_isLocatedIn_Country")
        .sourceLabel("Organisation")
        .targetLabel("Place")
        .ifNotExist()
        .create();

schema.edgeLabel("City_isPartOf_Country")
        .sourceLabel("Place")
        .targetLabel("Place")
        .ifNotExist()
        .create();

schema.edgeLabel("Tag_hasType_TagClass")
        .sourceLabel("Tag")
        .targetLabel("TagClass")
        .ifNotExist()
        .create();

schema.edgeLabel("TagClass_isSubclassOf_TagClass")
        .sourceLabel("TagClass")
        .targetLabel("TagClass")
        .ifNotExist()
        .create();
