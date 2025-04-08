function Button({ onClick, value, className}) {
          return <button className={className} onClick={onClick}>{value}</button>;
}

export default Button;