
export module Environment {
    export class Component {
        protected type!: string;
        protected parent!: Component | null;
        protected children !: Component[];

        public setParent(parent: Component | null) {
            this.parent = parent;
        }

        public getParent(): Component | null {
            return this.parent;
        }

        public add(component: Component): void { }
        public remove(component: Component): void { }

        public isComposite(): boolean {
            return false;
        }

        public render(): string { return "" };
    }

    export class Container extends Component {
        type = "Container";
        children: Component[] = [];

        public add(component: Component): void {
            this.children.push(component);
            component.setParent(this);
        }

        public remove(component: Component): void {
            const componentIndex = this.children.indexOf(component);
            this.children.splice(componentIndex, 1);

            component.setParent(null);
        }

        public isComposite(): boolean {
            return true;
        }

        public render(): string {
            const results: string[] = [];
            for (const child of this.children) {
                results.push(child.render());
            }

            return `${this.type}(${results.join('+')})`;
        }
    }

    export class Board extends Container {
        type: string = "Board";
        children: Component[] = []
    }

    export class Frame extends Container {
        type: string = "Frame";
        children: Component[] = []
    }

    export class Table extends Component {
        type: string = "Table";
        children: Component[] = []
        public render(): string {
            return "Table";
        }
    }
}



type jsonType = {
    type: elementTypes
    children?: {
        type: elementTypes;
        children?: jsonType["children"];
    }[]
}

type elementTypes = "Board" | "Frame" | "Table"

var json: jsonType = {
    "type": "Board",
    "children": [
        {
            "type": "Frame",
            "children": [
                {
                    "type": "Table"
                }
            ]
        },
        {
            "type": "Frame",
            "children": [
                {
                    "type": "Table"
                },
                {
                    "type": "Table"
                }
            ]
        }
    ]
}

function deserialize(json: any, environment: any) {
    if (Array.isArray(json)) {
        json.forEach((value: any) => deserialize(value, environment));
    }
    var instance = new environment[json.type]();
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

let test = deserialize(json, Environment);
console.log(test)