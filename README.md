# Keycloak Extension Samples

This repo contains the following samples:

* Custom Protocol Mapper -> Needed to add custom JWT Claims 
* JAx Rs Endpoint : Base Extension to add new features and small enhancements, which are often needed in projects

During the project i´m currently working on, i had the opportunity to dive into Keycloak. The following is a brief and comprehensive summary of what i have learned so far and which would be also important for you someday.. because usu actually set keycloak as the de-facto standard IAM solution in their products. Furthermore many clients do ask for the knowledge regarding that product.  
Additionally i was able to extract two types of custom extensions, which we have been using quite extensively in our project. So i will also demonstrate how to add custom JAX-RS Endpoints and custom protocol mappers (eg. for additional JWT claims ) The project itself also includes customs SPIs (service provider interfaces ) and custom JPA extensions. If requested, i can extract/elaborate also on these.. 

So back to Keycloak in general .., 
The product is mainly driven by Jboss/RedHat nowadays IBM. Keylclaok is the open-source version of RedHat SSO. The primary use-cases are SAML & OAuth 2 & OIDC SSO scenarios. The base of the product itself is a wildfly application server with an angular UI on top.

The first base concept is a realm. A realm manages a set of users, credentials, roles, and groups. Inside of a realm the configuration of partying applications are done via creating clients. The client defines which roles , attributes and groups a user has in this context. Technically, the integration is done with so called adapters. Further information about using keycloak can be extracted out of the training marcus mattersdorfer gave.
But as a summary, i can tell you .. using keycloak is quite fine. The issues arise when you try to extend it. 

The problem lies within the missing implementation details normal developers have, when not implementing keycloak fulltime. It starts with the server developer documentation itelf, because it only contains the extension points.
The extension API mainly consists of traditonal SPI interfaces, which is actually not that what you would expect, when starting a wildfly java ee application server with an "app". i would recommend to remember that component style by reading the oracle documentation (or just remember to not forget to add the service declarations in META-INF/services and please double check the typing of the class names  or use googles auto service dependency).

But that´s in the end quite straight forward. The main problem is using the internal API. All these nice looking getters, but i haven´t found any information about how or when to use what so far. so preparate yourself to be in a NullPointerException bug-hunting session for quite some time, when using the API. 

After digging at the surface i will now go a bit deeper .. directly jumping to custom jax rs endpoints in keycloak.
As previusly mentioned keycloak extensions are based upon service provider interfaces. The Jax Rs Endpoint  buils upon the 
