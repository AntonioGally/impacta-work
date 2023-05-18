export module Environment {
    export class Member {
        private __name__ = "Member";
        id: number | undefined;

        print() {
            console.log("Id", this.id)
        }
    }

    export class ExampleClass {
        private __name__ = "ExampleClass";

        mainId: number | undefined;
        firstMember: Member | undefined;
        secondMember: Member | undefined;

        print() {
            console.log("Main ID", this.mainId)
        }
    }
}

function deserialize(json: any, environment: any) {
    var instance = new environment[json.__name__]();
    for (var prop in json) {
        if (!json.hasOwnProperty(prop)) {
            continue;
        }

        if (typeof json[prop] === 'object') {
            instance[prop] = deserialize(json[prop], environment);
        } else {
            instance[prop] = json[prop];
        }
    }

    return instance;
}

var json = {
    __name__: "ExampleClass",
    mainId: 42,
    firstMember: {
        __name__: "Member",
        id: 1337
    },
    secondMember: {
        __name__: "Member",
        id: -1
    }
};

var instance = deserialize(json, Environment);
console.log(instance.firstMember.print());
