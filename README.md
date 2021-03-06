# ph-jaxb22-plugin

JAXB 2.2 plugin that adds some commonly needed functionality.
The version 2.2.7 is linked against JAXB 2.2.7.
The current version 2.2.11.6 is linked against JAXB 2.2.11.


# News and noteworthy

* v2.2.11.11 - 2018-03-13
  * Fixed a problem in `cloneTo` with `null` `List` values 
* v2.2.11.10 - 2017-11-05
  * Updated to ph-commons 9.0.0
* v2.2.11.9 - 2017-02-16
  * Added -Xph-tostring requires ph-commons >= 8.6.2 
  * Added -Xph-tostring-legacy
* v2.2.11.8 - 2016-07-27
  * Fixed bug in cloning of abstract class
* v2.2.11.7 - 2016-06-10
  * JDK8 is required
  * Added generic cloning 
  * the `ph-csu` settings is now also applied on nested generated classes
* v2.2.11.6 - 2015-07-21
  * Fixed error in 'getXXXCount' method name
* v2.2.11.5 - 2015-07-01
  * Extended 'ph-list-extension' with the "add" method
  * Updated to ph-commons 6.0.0
* v2.2.11.4 - 2015-03-31
  * Disabled the parameter renaming in the PluginCodeQuality so that JavaDocs can be generated with Java 8
* v2.2.11.3 - 2015-03-11
* v2.2.11.2 - 2015-02-06
 * Extended 'ph-csu' for all enums as well
* v2.2.11.1 - 2015-02-06
  * Added new option 'ph-csu' to add the CodingStyleguideUnaware annotation to all classes
* v2.2.11 - 2014-12-02
  * linked against JAXB 2.2.11
* v2.2.7 - 2014-08-24
  * linked against JAXB 2.2.7

# Maven usage
Add something **like** the following to your pom.xml to use this artifact:

```xml
      <plugin>
        <groupId>org.jvnet.jaxb2.maven2</groupId>
        <artifactId>maven-jaxb2-plugin</artifactId>
        <version>0.13.3</version>
        <executions>
          <execution>
            <goals>
              <goal>generate</goal>
            </goals>
          </execution>
        </executions>
        <configuration>
          ...regular plugin configuration...
          <args>
            ...other direct arguments like -no-header...
            <arg>-Xph-default-locale</arg>
            <arg>en_US</arg>
            <arg>-Xph-annotate</arg>
            <arg>-Xph-fields-private</arg>
            <arg>-Xph-code-quality</arg>
            <arg>-Xph-implements</arg>
            <arg>java.io.Serializable</arg>
            <arg>-Xph-equalshashcode</arg>
            <arg>-Xph-tostring</arg>
            <arg>-Xph-list-extension</arg>
            <arg>-Xph-bean-validation11</arg>
            <arg>-Xph-csu</arg>
          </args>
        </configuration>
        <dependencies>
          <dependency>
            <groupId>com.helger</groupId>
            <artifactId>ph-jaxb22-plugin</artifactId>
            <version>2.2.11.11</version>
          </dependency>
        </dependencies>
      </plugin>
```

# JAXB Plugins

  * `ph-annotate` - Create `@javax.annotation.Nonnull`/`@javax.annotation.Nullable` annotations in all bean generated objects as well as in the `ObjectFactory` classes
  * `ph-bean-validation10` - inject Bean validation 1.0 annotations (JSR 303)
  * `ph-bean-validation11` - inject Bean validation 1.1 annotations (JSR 349)
  * `ph-cloneable` (since 2.2.11.7) - implement clone() of Cloneable interface and cloneTo(target). This requires the created code to depend on [ph-commons](https://github.com/phax/ph-commons).
  * `ph-code-quality` - fix some issues that cause warnings in the generated code
  * `ph-csu` - add `@CodingStyleguideUnaware` annotations to all classes
  * `ph-default-locale` `locale` - set Java default locale to the specified parameter. Use e.g. `en_US`
  * `ph-equalshashcode` - auto implement equals and hashCode using `com.helger.commons.equals.EqualsHelper` and `com.helger.commons.hashcode.HashCodeGenerator`. This requires the created code to depend on [ph-commons](https://github.com/phax/ph-commons). 
  * `ph-fields-private` - mark all fields as private
  * `ph-implements` `fullyQualifiedInterfaceName[,otherInterfaceName]` - implement 1-n interfaces in all classes/enums (e.g. `java.io.Serializable`)
  * `ph-list-extension` - add additional methods for `List` types:
    * `void set...(List)` - set a new `List`
    * `boolean has...Entries()` - returns `true` if at least one entry is present
    * `boolean hasNo...Entries()` - returns `true` if no entry is present
    * `int get...Count()` - returns the number of contained entries
    * `T get...AtIndex(int)` - get the element at the specified index
    * `void add...(T)` - add a new entry to the list
  * `ph-tostring` - auto implement `toString` using `com.helger.commons.string.ToStringGenerator.getToString()`. This requires the created code to depend on [ph-commons >= 8.6.2](https://github.com/phax/ph-commons). 
  * `ph-tostring-legacy` (since 2.2.11.9) - auto implement `toString` using `com.helger.commons.string.ToStringGenerator.toString()`. This requires the created code to depend on [ph-commons <= 8.6.1](https://github.com/phax/ph-commons). 

---

My personal [Coding Styleguide](https://github.com/phax/meta/blob/master/CodingStyleguide.md) |
On Twitter: <a href="https://twitter.com/philiphelger">@philiphelger</a>
