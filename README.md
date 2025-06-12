# Backstage Software Templates

This repository hosts a curated collection of Backstage *Software Templates* (sometimes called the “Golden Path”).  
These templates let engineers bootstrap new services, libraries, or other resources in a consistent, production-ready manner.

## Repository layout

```
templates/            # one sub-directory per template
└── NAME/             # template slug (kebab-case)
    ├── template.yaml # Backstage Template spec (mandatory)
    └── skeleton/     # files copied into the new component
templates.yaml        # aggregator file that Backstage reads
```

## Available templates

Below is a generated catalog of every template in `templates/*/template.yaml`.

_No templates available yet_

> **Tip**  In Backstage you can paste the raw URL of one of the individual `template.yaml` files above  
> to the *Register Existing Component* flow and preview it before scaffolding.

## How to use these templates

1. **Via Backstage UI**  
   • In your Backstage instance, open *Create… ➜ Register existing component*.  
   • Paste the raw URL to this repository’s `templates.yaml` file  
     (e.g. `https://raw.githubusercontent.com/ORG/REPO/main/templates.yaml`).  
   • Browse the templates and click *Choose* to scaffold.

2. **Via Backstage CLI**  
```bash
npx @backstage/create-app --from https://raw.githubusercontent.com/ORG/REPO/main/templates.yaml
```

## Contributing a new template

1. Create a new directory under `templates/` following kebab-case naming.  
2. Author `template.yaml` describing the template (see other examples).  
3. Add a `skeleton/` folder containing the files that will be generated.  
4. Run `yarn backstage-cli validate` (or equivalent) to lint the spec.  
5. Submit a pull request—CI will ensure the template renders correctly.

## License

Apache-2.0 © 2025